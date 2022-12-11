package core.Tables;

import core.ui.Elements;
import core.ui.MenuUi;
import core.ui.UiTable;
import core.funcs.ButtonRun;
import mindustry.gen.Player;

public class ButtonTable extends UiTable {
    public ButtonRun Run;
    public ButtonTable(String m, ButtonRun run,boolean c){
        super(m);
        Run=run;
        close=c;
    }

    @Override
    public void run(Player p, Object data, Elements ui) {
        super.run(p, data, ui);
        Run.get(p,data,ui);
    }
}
