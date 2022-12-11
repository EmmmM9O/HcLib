package core;

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
    public Vector<Vector<UiTable>> elements=new Vector<>();
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
    public void text(String message){
        now.add(new TextTable(message));
    }
    public void button(String m, ButtonRun run){
        now.add(new ButtonTable(m,run));
    }
    public void row(){

        elements.add(new Vector<>(now));
        now.clear();
    }
    public void show(Player p,Object addon){
        int Max=0;
        for (var i:elements){
            Max=Math.max(Max,i.size());
        }
        if(data.containsKey(p.uuid())){
            data.put(p.uuid(),addon);
        }
        data.put(p.uuid(),addon);
        String title=Title.get(p),desc= Desc.get(p);
        if (now.size()>0) row();
        String[][] s=new String[elements.size()+1][Max+1];
        Vector<UiTable> sh=new Vector<>();
        for (int i=0;i<elements.size();i++){
            var k=elements.get(i);
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
            sh.get(option).run(player,data.get(player.uuid()),that);
        }));
        Call.menu(p.con,id.get(p.uuid()),title,desc,s);
    }
}
