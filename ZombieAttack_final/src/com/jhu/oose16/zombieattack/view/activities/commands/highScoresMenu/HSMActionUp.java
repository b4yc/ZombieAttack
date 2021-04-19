public class HSMActionUp implements HSMCommand {
    public void execute(ViewComponentManager viewComponentManager){
        ((Button) viewComponentManager.getViewComponent(ViewComponentTypes.RETURN_MAIN_MENU_BUTTON)).buttonUp();
    }
}