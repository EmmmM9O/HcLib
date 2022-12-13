package core.funcs;

import core.ui.Elements;
import mindustry.gen.Player;

public interface IntButton extends ButtonRun<Integer>{
    @Override
    void get(Player p, Integer data, Elements ui);
}
