public class CMMainMenuActionUp implements CMCommand {
    public void execute(CreditMenu c, MainMenu m){
        Intent intent = new Intent();
		intent.setClass(c.this, m.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(intent);
		finish();
    }
}