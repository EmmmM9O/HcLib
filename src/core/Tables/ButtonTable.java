package core.Tables;

import core.MenuUi;
import core.UiTable;
import core.funcs.ButtonRun;
import mindustry.gen.Player;

public class ButtonTable extends UiTable {
    public ButtonRun Run;
    public ButtonTable(String m, ButtonRun run){
        super(m);
        Run=run;
    }

    @Override
    public void run(Player p, Object data, MenuUi ui) {
        super.run(p, data, ui);
        Run.get(p,data,ui);
    }
}
