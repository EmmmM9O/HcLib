package core.funcs;

import core.Data;
import core.ui.Elements;
import mindustry.gen.Player;

import java.util.Map;

public interface ButtonRun <T>{

    T get(Player p, T data, Elements ui);
}
