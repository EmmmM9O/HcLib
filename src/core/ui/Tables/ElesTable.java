package core.ui.Tables;


import core.funcs.ButtonRun;
import core.ui.Elements;
import core.ui.UiTable;
import mindustry.gen.Player;

public class ElesTable extends UiTable {
    @Override
    public boolean show(Player p, Object data) {
        return false;
    }
    public ButtonRun ElesRun;

    @Override
    public void near(Player p, Object data, Elements ui) {
        ElesRun.get(p,data,ui);
    }

    public ElesTable(String text, ButtonRun run){
        super(text);ElesRun=run;
    }
}
