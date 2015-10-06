package factories;

public class UnitFactory {
	private static UnitFactory instance;

    private UnitFactory() { }

    public static UnitFactory getInstance() {

        if (instance == null)
        {
            instance = new UnitFactory();
        }
        return instance;
    }
    
    //TODO Unit generate
}
