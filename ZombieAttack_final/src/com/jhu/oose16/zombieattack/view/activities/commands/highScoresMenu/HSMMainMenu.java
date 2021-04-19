public class HSMMainMenu implements HSMCommand {
    public void execute (ViewComponentManager viewComponentManager, Event event){
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
			((Button) viewComponentManager.getViewComponent(ViewComponentTypes.RETURN_MAIN_MENU_BUTTON)).buttonDown();
			if (MainMenu.music_sound_on) {
				MainMenu.touchSong.start();
			}
		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			Intent intent = new Intent();
			intent.setClass(HighScoresMenu.this, MainMenu.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			startActivity(intent);
			finish();
		}
    }
}