package dataModel;

public class HeadingWidget extends Widget{
	
	private int headingWidgetId;
	private int size;
	

	
	public HeadingWidget(int widgetId, String name, int width, int height, String cssClass, String cssStyle,
			String text, int order, int pageId, String type, int headingWidgetId, int size) {
		super(widgetId, name, width, height, cssClass, cssStyle, text, order, pageId, type);
		this.headingWidgetId = headingWidgetId;
		this.size = size;
	}

	public HeadingWidget() {
		super();
	}

	public int getHeadingWidgetId() {
		return headingWidgetId;
	}
	
	public int getSize() {
		return size;
	}

	public void setHeadingWidgetId(int headingWidgetId) {
		this.headingWidgetId = headingWidgetId;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public String getType() {
		return "heading";
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
			   this.getHeadingWidgetId() + "\n " +
			   this.getSize() + "\n ";
	}
	

}
