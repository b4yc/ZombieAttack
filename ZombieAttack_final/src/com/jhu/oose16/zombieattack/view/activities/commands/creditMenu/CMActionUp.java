class CMActionUp implements CMCommand {
    public void execute(ViewComponentManager){
        ((Button) viewComponentManager.getViewComponent(ViewComponentTypes.RETURN_MAIN_MENU_BUTTON)).buttonUp();
    }
}