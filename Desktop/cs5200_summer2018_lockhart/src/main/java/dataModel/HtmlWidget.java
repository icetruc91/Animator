package dataModel;

public class HtmlWidget extends Widget{

	private int htmlWidgetId;
	private String html;

	
	
	public HtmlWidget(int widgetId, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, int pageId, String type, int htmlWidgetId, String html) {
		super(widgetId, name, width, height, cssClass, cssStyle, text, order, pageId, type);
		this.htmlWidgetId = htmlWidgetId;
		this.html = html;
	}

	public HtmlWidget() {
		super();
	}

	public void setHtmlWidgetId(int htmlWidgetId) {
		this.htmlWidgetId = htmlWidgetId;
	}

	public void setHtml(String html) {
		this.html = html;
	}
	
	public String getHtml() {
		return html;
	}
	
	public int getHtmlWidgetId() {
		return htmlWidgetId;
	}
	
	public String getType() {
		return "html";
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
			   this.getHtmlWidgetId() + "\n " +
			   this.getSize() + "\n " +
			   this.getHtml() + "\n ";
	}
	
}
