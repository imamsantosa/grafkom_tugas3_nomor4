package min3d.sampleProject1;


import android.util.Log;
import android.view.KeyEvent;
import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.parser.IParser;
import min3d.parser.Parser;
import min3d.vos.Light;

/**
 * How to load a model from a .obj file
 * 
 * @author dennis.ippel
 * 
 */
public class ExampleLoadObjFile extends RendererActivity {
	private Object3dContainer objModel;

	@Override
	public void initScene() {
		
		scene.lights().add(new Light());
		
		
		
		/*IParser parser = Parser.createParser(Parser.Type.OBJ,
				getResources(), "min3d.sampleProject1:raw/camaro_obj", true);*/
		IParser parser = Parser.createParser(Parser.Type.OBJ,
				getResources(), "min3d.sampleProject1:raw/city_obj", true);
		parser.parse();
		
		//LoaderOBJ objParser = new LoaderOBJ(mContext.getResources(),
		//		mTextureManager, R.raw.ibot_obj);

		objModel = parser.getParsedObject();
		//objModel.scale().x = objModel.scale().y = objModel.scale().z = .7f;
		objModel.scale().x = objModel.scale().y = objModel.scale().z = .003f;
		objModel.position().y=-1f;
		objModel.position().x=1f;
		objModel.position().z=-1.5f;
		scene.addChild(objModel);
	}
	private float motion = 0.1f;

	@Override
	public void updateScene() {
//		objModel.rotation().x++;
//		objModel.rotation().z++;
//		objModel.rotation().y++;
	}
	
	public void maju(){
		objModel.position().z += motion;
	}
	
	public void mundur(){
		objModel.position().z -= motion;
	}
	
	public void naik(){
		objModel.position().y += motion;
	}
	
	public void turun(){
		objModel.position().y -= motion;
	}
	
	public void geserKanan(){
		objModel.position().x += motion;
	}
	
	public void geserKiri(){
		objModel.position().x -= motion;
	}
	
	public void lihatBawah(){
		objModel.rotation().x--;
	}
	
	public void lihatAtas(){
		objModel.rotation().x++;
	}
	
	public void lihatKanan(){
		objModel.rotation().y++;
	}
	
	public void lihatKiri(){
		objModel.rotation().y--;
	}
	
	
	 public boolean onKeyDown(int keyCode, KeyEvent event) {
    	switch (keyCode) {
			case KeyEvent.KEYCODE_W:
				Log.v("test W", "work");
				maju();
				break;
			case KeyEvent.KEYCODE_S:
				Log.v("test S", "work");
				mundur();
				break;
			case KeyEvent.KEYCODE_Q:
				Log.v("test Q", "work");
				naik();
				break;
			case KeyEvent.KEYCODE_E:
				Log.v("test E", "work");
				turun();
				break;
			case KeyEvent.KEYCODE_D:
				Log.v("test up", "work");
				geserKiri();
				break;
			case KeyEvent.KEYCODE_A:
				Log.v("test down", "work");
				geserKanan();
				break;
			case KeyEvent.KEYCODE_DPAD_UP:
				Log.v("up", "work");
				lihatAtas();
				break;
			case KeyEvent.KEYCODE_DPAD_DOWN:
				Log.v("down", "work");
				lihatBawah();
				break;
			case KeyEvent.KEYCODE_DPAD_RIGHT:
				Log.v("right", "work");
				lihatKanan();
				break;
			case KeyEvent.KEYCODE_DPAD_LEFT:
				Log.v("right", "work");
				lihatKiri();
				break;
    	}
			
    	return true;
    }
}
