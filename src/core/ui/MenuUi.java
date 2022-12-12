package core.ui;

import arc.util.Nullable;
import core.Tables.ButtonTable;
import core.Tables.TextTable;
import core.funcs.ButtonRun;
import core.funcs.GetSFunc;
import mindustry.gen.Call;
import mindustry.gen.Player;
import mindustry.ui.Menus;


import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class MenuUi {
    public Map<String,Integer> id=new HashMap<>();
    public Map<String,Object> data=new HashMap<>();
    public Elements elements=new Elements();
    public Vector<UiTable> now=new Vector<>();
    @Nullable
    public GetSFunc<Player> Title;
    public GetSFunc<Player> Desc;
    public MenuUi(String title,String desc){
        Title=(player -> title);
        Desc=(player -> desc);
    }
    public MenuUi(GetSFunc t,GetSFunc d){
        Title=t;Desc=d;
    }

    public void show(Player p,Object addon){
        var ew=elements.get();

        var ee=new Elements();
        for (var i:ew){
            for (var k:i){
                k.near(p,addon,ee);

                ee.add(k);
            }

            ee.row();
        }
        var e=ee.get();
        int Max=0;
        for (var i:e){
            Max=Math.max(Max,i.size());
        }
        if(data.containsKey(p.uuid())){
            data.put(p.uuid(),addon);
        }
        data.put(p.uuid(),addon);
        String title=Title.get(p),desc= Desc.get(p);
        if (now.size()>0) elements.row();
        String[][] s=new String[e.size()+1][Max+1];
        Vector<UiTable> sh=new Vector<>();
        for (int i=0;i<e.size();i++){
            var k=elements.o.get(i);
            for (int j=0;j<k.size();j++){
                if(k.get(i).show(p,data.get(p.uuid()))){
                    s[i][j]=k.get(j).Message.get(p);
                    sh.add(k.get(j));
                }
            }
        }
        var that=this;
        id.put(p.uuid(), Menus.registerMenu((player, option) ->{
            if(option>=sh.size()) return;
            sh.get(option).run(player,data.get(player.uuid()),ee);
            if(!sh.get(option).close) show(player,data.get(player.uuid()));
        }));
        Call.menu(p.con,id.get(p.uuid()),title,desc,s);
    }
}
