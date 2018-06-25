package dataModel;

public class YouTubeWidget extends Widget {
	
	private int youtTubeWidgetId;
	private String url;
	private Boolean shareable;
	private Boolean expandable;
	
	
	
	public YouTubeWidget(int widgetId, String name, int width, int height, String cssClass, String cssStyle,
			String text, int order, int pageId, String type, int youtTubeWidgetId, String url, Boolean shareable,
			Boolean expandable) {
		super(widgetId, name, width, height, cssClass, cssStyle, text, order, pageId, type);
		this.youtTubeWidgetId = youtTubeWidgetId;
		this.url = url;
		this.shareable = shareable;
		this.expandable = expandable;
	}

	public YouTubeWidget() {
		super();
	}
	
	public int getYoutTubeWidgetId() {
		return youtTubeWidgetId;
	}
	
	public Boolean getExpandable() {
		return expandable;
	}
	
	public Boolean getShareable() {
		return shareable;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setYoutTubeWidgetId(int youtTubeWidgetId) {
		this.youtTubeWidgetId = youtTubeWidgetId;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setShareable(Boolean shareable) {
		this.shareable = shareable;
	}
	
	public void setExpandable(Boolean expandable) {
		this.expandable = expandable;
	}
	
	public String getType() {
		return "youtube";
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
			   this.getYoutTubeWidgetId() + "\n "+
			   this.getSize() + "\n " +
			   this.getSrc() + "\n " +
			   this.getExpandable() + "\n " +
			   this.getShareable() + "\n " +
			   this.getUrl() + "\n ";
	}
	
	

}
