package dataModel;

public class ImageWidget extends Widget{

	private String src;
	private int imageWidgetId;
	
	public ImageWidget(int widgetId, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, int pageId, String type, String src, int imageWidgetId) {
		super(widgetId, name, width, height, cssClass, cssStyle, text, order, pageId, type);
		this.src = src;
		this.imageWidgetId = imageWidgetId;
	}
	

	public ImageWidget() {
		super();
	}

	public int getImageWidgetId() {
		return imageWidgetId;
	}
	
	public String getSrc() {
		return src;
	}

	public void setImageWidgetId(int imageWidgetId) {
		this.imageWidgetId = imageWidgetId;
	}


	public void setSrc(String src) {
		this.src = src;
	}
	
	public String getType() {
		return "image";
	}
	
	public String toString() {
		return this.getWidgetId() + "\n " +
			   this.getName() + "\n " +
			   this.getWidth() + "\n " +
			   this.getHeight() + "\n " +
			   this.getCssClass() + "\n " +
			   this.getCssStyle() + "\n " +
			   this.getText() + "\n " +
			   this.getOrder() + "\n " +
			   this.getPageId() + "\n " +
			   this.getType() + "\n " +
			   this.getImageWidgetId() + "\n "+
			   this.getSize() + "\n " +
			   this.getSrc() + "\n ";
	}
	
}
