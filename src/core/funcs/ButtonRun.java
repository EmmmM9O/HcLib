package core.funcs;

import core.ui.Elements;
import mindustry.gen.Player;

import java.util.Map;

public interface ButtonRun {

    void get(Player p,Map<String,? extends Object> data, Elements ui);
}
