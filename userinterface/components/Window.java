package components;

import graphics.ShapeFactory;
import graphics.TextureFactory;
import components.Component;
import ui.ComponentRenderData;
import ui.ComponentElement;

public class Window extends Component {
	
	private static final String TEXTURE_BODY = "window_backdrop";
	
	public Window() {
		super();
	}
	
	@Override
	public ComponentRenderData getComponentRenderData() {
		if(super.renderDataCache != null) {
			return super.renderDataCache;
		} else {
			// Dimensions
			final ComponentElement body = new ComponentElement(
					super.getWidth(), super.getHeight());
			
			final ShapeFactory sf = ShapeFactory.getInstance();
			final TextureFactory tf = TextureFactory.getIntance();
			
			// Shapes
			body.setShape(sf.createQuad(body.getWidth(), body.getHeight()));
						
			// Textures
			body.setTexture(tf.createTexture(TEXTURE_BODY));
			
			// Finalize
			final ComponentRenderData data = new ComponentRenderData(body);
			for(Component child : super.getChildren()) {
				data.addChildren(child.getComponentRenderData());
			}
			super.renderDataCache = data;
			return super.renderDataCache;
		}
	}
	
}
