package core.ui;

import core.ui.Tables.ButtonTable;
import core.ui.Tables.TextTable;
import core.funcs.ButtonRun;

import java.util.Vector;

public class Elements <T>{
    public Elements(){

    }
    public Vector<Vector<UiTable<T>>> o=new Vector<>();
    public Vector<UiTable<T>> now=new Vector<>();
    public void text(String message){
        now.add(new TextTable(message));
    }
    public void button(String m, ButtonRun run,boolean c){
        now.add(new ButtonTable(m,run,c));
    }

    public void row(){

        o.add(new Vector<>(now));
        now.clear();
    }
    public Vector<Vector<UiTable<T>>> get(){
        var k=new Vector<>(o);
        if(now.size()>0)k.add(now);
        return k;
    }
    public void add(UiTable<T> tt){
        now.add(tt);

    }


}
