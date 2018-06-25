package dataModel;

public abstract class Widget {
	
	private int widgetId;
	private String name;
	private int width;
	private int height;
	private String cssClass;
	private String cssStyle;
	private String text;
	private int order;
	private int pageId;
	private String type;
	
	
	public Widget(int widgetId, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, int pageId, String type) {
		super();
		this.widgetId = widgetId;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		this.pageId = pageId;
		this.setType(type);
	}
	
	public Widget() {
		super();
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(int widgetId) {
		this.widgetId = widgetId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public String getCssStyle() {
		return cssStyle;
	}
	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	public String getType() {
		return "widget";
	}

	public String getHtml() {
		return null;
	}
	
	public int getHtmlWidgetId() {
		return 0;
	}
	
	public int getImageWidgetId() {
		return 0;
	}
	
	public String getSrc() {
		return null;
	}
	
	public int getHeadingWidgetId() {
		return 0;
	}
	
	public int getSize() {
		return 0;
	}
	
	public int getYoutTubeWidgetId() {
		return 0;
	}
	
	public Boolean getExpandable() {
		return null;
	}
	
	public Boolean getShareable() {
		return null;
	}
	
	public String getUrl() {
		return null;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
