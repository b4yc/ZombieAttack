public class LMMainMenu implements LMCommand {
    public void execute (ViewComponentManager viewComponentManager, Event event){
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
				((Button) viewComponentManager
						.getViewComponent(ViewComponentTypes.RETURN_MAIN_MENU_BUTTON))
						.buttonDown();
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				sendBroadcast(new Intent("finishGamePlay"));

				Intent intent = new Intent();
				intent.setClass(LoseMenu.this, MainMenu.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);

				finish();
			}
    }
}