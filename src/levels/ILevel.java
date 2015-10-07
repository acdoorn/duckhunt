package levels;

import models.Unit;
import controllers.GameController;

public interface ILevel {

    Unit TryCreateUnit(GameController game);
    void Update(GameController Game);

}
