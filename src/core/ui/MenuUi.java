package core.ui;

import arc.util.Nullable;
import core.Data;
import core.funcs.GetSFunc;
import mindustry.gen.Call;
import mindustry.gen.Player;
import mindustry.ui.Menus;


import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class MenuUi <T>{
    public Map<String,Integer> id=new HashMap<>();
    public Map<String,T> data=new HashMap<>();
    public Elements<T> elements=new Elements();
    public Vector<UiTable<T>> now=new Vector<>();
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

    public void show(Player p,T addon){
        var ew=elements.get();

        var ee=new Elements<T>();
        for (var i:ew){
            for (var k:i){
                data.put(p.uuid(),k.near(p,addon,ee));

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
        Vector<UiTable<T>> sh=new Vector<>();
        for (int i=0;i<e.size();i++){
            var k=e.get(i);
            for (int j=0;j<k.size();j++){
                if(k.get(i).show(p,data.get(p.uuid()))){
                    s[i][j]=k.get(j).Message.get(p);
                    sh.add(k.get(j));
                }
            }
        }

        id.put(p.uuid(), Menus.registerMenu((player, option) ->{
            if(option>=sh.size()) return;
            data.put(p.uuid(),sh.get(option).run(player,data.get(player.uuid()),ee));
            if(!sh.get(option).close) show(player,data.get(player.uuid()));
        }));
        Call.menu(p.con,id.get(p.uuid()),title,desc,s);
    }
}
