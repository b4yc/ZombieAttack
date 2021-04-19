public class LMActionUp implements LMCommand {
    public void execute (ViewComponentManager viewComponentManager){
        ((Button) viewComponentManager.getViewComponent(ViewComponentTypes.RETRY_BUTTON)).buttonUp();
		((Button) viewComponentManager.getViewComponent(ViewComponentTypes.RETURN_MAIN_MENU_BUTTON)).buttonUp();
    }
}