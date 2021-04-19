public interface MMCommand {
    public void execute (ViewComponentManager viewComponentManager, Event event, MainMenu mainMenu, GamePlay gamePlay);
    public void execute (ViewComponentManager, Event);
    public void execute (ViewComponentManager);
}