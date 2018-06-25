package model;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dataModel.HeadingWidget;
import dataModel.HtmlWidget;
import dataModel.ImageWidget;
import dataModel.Widget;
import dataModel.YouTubeWidget;

public class WidgetDao extends BaseDAO{

	private static WidgetDao instance = null;
	private WidgetDao() {}
	public static WidgetDao getInstance() {
		if(instance == null) {
			instance = new WidgetDao();
		}
		return instance;
	}
	
	final String CREATE_WIDGET = "INSERT INTO Widget (widgetId, name, width, height, cssClass, cssStyle, text, order, url, shareable, expandable, src, html, size, pageId, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	final String FIND_ALL_WIDGETS = "SELECT * FROM Widget";
	final String FIND_WIDGET_BY_WIDGETID = "SELECT * FROM Widget WHERE widgetId=?";
	final String FIND_WIDGETS_FOR_PAGE = "SELECT * FROM Widget WHERE pageId=?";
	final String UPDATE_WIDGET = "UPDATE Widget SET widgetId=?, name=?, width=?, "
			+ "height=?, cssClass=?, cssStyle=?, text=?, order=?, url=?, shareable=?, "
			+ "expandable=?, src=?, html=?, size=?, pageId=?, type=? WHERE widgetId=?";
	final String DELETE_WIDGET = "DELETE FROM Widget WHERE widgetId=?";
	
	
	@SuppressWarnings("null")
	public int createWidgetForPage(int pageId, Widget widget) {
		connection = null;
		pstmt = null;
		
		int result = 0;
		
		try {
		      Class.forName(JDBC_DRIVER);
		      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		      pstmt = connection.prepareStatement(CREATE_WIDGET);
		      
					if(widget.getType().toString() == "youtube") {
						pstmt.setInt(1, widget.getWidgetId());
					      pstmt.setString(2, widget.getName());
					      pstmt.setInt(3, widget.getWidth());
					      pstmt.setInt(4, widget.getHeight());
					      pstmt.setString(5, widget.getCssClass());
					      pstmt.setString(6, widget.getCssStyle());
					      pstmt.setString(7, widget.getText());
					      pstmt.setInt(8, widget.getOrder());
					      pstmt.setString(9, widget.getUrl());
					      pstmt.setBoolean(10, widget.getShareable());
					      pstmt.setBoolean(11, widget.getExpandable());
					      pstmt.setString(12, null);
					      pstmt.setString(13, null);
					      pstmt.setInt(14, 0);
					      pstmt.setInt(15, pageId);
					      pstmt.setString(16, "youtube");
					}
					else if(widget.getType().toString() == "heading") {
						pstmt.setInt(1, widget.getWidgetId());
					      pstmt.setString(2, widget.getName());
					      pstmt.setInt(3, widget.getWidth());
					      pstmt.setInt(4, widget.getHeight());
					      pstmt.setString(5, widget.getCssClass());
					      pstmt.setString(6, widget.getCssStyle());
					      pstmt.setString(7, widget.getText());
					      pstmt.setInt(8, widget.getOrder());
					      pstmt.setString(9, null);
					      pstmt.setBoolean(10, (Boolean) null);
					      pstmt.setBoolean(11, (Boolean) null);
					      pstmt.setString(12, null);
					      pstmt.setString(13, null);
					      pstmt.setInt(14, widget.getSize());
					      pstmt.setInt(15, pageId);
					      pstmt.setString(16, "heading");
						
						
					      
					}
					else if(widget.getType().toString() == "html") {
						pstmt.setString(2, widget.getName());
					      pstmt.setInt(3, widget.getWidth());
					      pstmt.setInt(4, widget.getHeight());
					      pstmt.setString(5, widget.getCssClass());
					      pstmt.setString(6, widget.getCssStyle());
					      pstmt.setString(7, widget.getText());
					      pstmt.setInt(8, widget.getOrder());
					      pstmt.setString(9, null);
					      pstmt.setBoolean(10, (Boolean) null);
					      pstmt.setBoolean(11, (Boolean) null);
					      pstmt.setString(12, null);
					      pstmt.setString(13, widget.getHtml());
					      pstmt.setInt(14, 0);
					      pstmt.setInt(15, pageId);
					      pstmt.setString(16, "html");
					}
					
					else {
						
					      pstmt.setInt(1, widget.getWidgetId());
					      pstmt.setString(2, widget.getName());
					      pstmt.setInt(3, widget.getWidth());
					      pstmt.setInt(4, widget.getHeight());
					      pstmt.setString(5, widget.getCssClass());
					      pstmt.setString(6, widget.getCssStyle());
					      pstmt.setString(7, widget.getText());
					      pstmt.setInt(8, widget.getOrder());
					      pstmt.setString(9, null);
					      pstmt.setBoolean(10, (Boolean) null);
					      pstmt.setBoolean(11, (Boolean) null);
					      pstmt.setString(12, widget.getSrc());
					      pstmt.setString(13, null);
					      pstmt.setInt(14, 0);
					      pstmt.setInt(15, pageId);
					      pstmt.setString(16, "image");
					}
					
					result = pstmt.executeUpdate();
					pstmt.close();
					connection.close();
					return result;
				      
		    } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			return 1;
			
			}
	
	
	public List<Widget> findAllWidgets() {
		List<Widget> widgets = new ArrayList<Widget>();
		connection = null;
		Statement stmt = null;
		ResultSet results = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = (Statement) connection.createStatement();
			results = stmt.executeQuery(FIND_ALL_WIDGETS);
			

			while(results.next()) {
//				Widget widget = new Widget();
				
				int widgetId = results.getInt("widgetId");
				String name = results.getString("name");
				int width = results.getInt("width");
				int height = results.getInt("height");
				String cssClass = results.getString("cssClass");
				String cssStyle = results.getString("cssStyle");
				String text = results.getString("text");
				int order = results.getInt("order");
				String url = results.getString("url");
				boolean shareable= results.getBoolean("shareable");
				boolean expandable= results.getBoolean("expandable");
				String src = results.getString("src");
				String html = results.getString("html");
				int size = results.getInt("size");
				int pageId = results.getInt("pageId");
				String type = results.getString("type");
				
			

				if(type.toString() == "youtube") {
					YouTubeWidget youtube = new YouTubeWidget();
					youtube.setWidgetId(widgetId);
					youtube.setName(name);
					youtube.setWidth(width);
					youtube.setHeight(height);
					youtube.setCssClass(cssClass);
					youtube.setCssStyle(cssStyle);
					youtube.setText(text);
					youtube.setOrder(order);
					youtube.setUrl(url);
					youtube.setShareable(shareable);
					youtube.setExpandable(expandable);
//					youtube.setSrc(src);
//					youtube.setHtml(html);
//					youtube.setSize(size);
					youtube.setPageId(pageId);
//					youtube.setType("youtube");
					widgets.add(youtube);
					
				}
				else if(type.toString() == "heading") {
					HeadingWidget heading = new HeadingWidget();
					heading.setWidgetId(widgetId);
					heading.setName(name);
					heading.setWidth(width);
					heading.setHeight(height);
					heading.setCssClass(cssClass);
					heading.setCssStyle(cssStyle);
					heading.setText(text);
					heading.setOrder(order);
//					heading.setUrl(url);
//					heading.setShareable(shareable);
//					heading.setExpandable(expandable);
//					heading.setSrc(src);
//					heading.setHtml(html);
					heading.setSize(size);
					heading.setPageId(pageId);
					heading.setType("heading");
					widgets.add(heading);
				}
				else if(type.toString() == "html") {
					HtmlWidget Html = new HtmlWidget();
					Html.setWidgetId(widgetId);
					Html.setName(name);
					Html.setWidth(width);
					Html.setHeight(height);
					Html.setCssClass(cssClass);
					Html.setCssStyle(cssStyle);
					Html.setText(text);
					Html.setOrder(order);
//					Html.setUrl(url);
//					Html.setShareable(shareable);
//					Html.setExpandable(expandable);
//					Html.setSrc(src);
					Html.setHtml(html);
//					Html.setSize(size);
					Html.setPageId(pageId);
//					Html.setType("html");
					widgets.add(Html);
					
				}
				else {
					ImageWidget image = new ImageWidget();
					image.setWidgetId(widgetId);
					image.setName(name);
					image.setWidth(width);
					image.setHeight(height);
					image.setCssClass(cssClass);
					image.setCssStyle(cssStyle);
					image.setText(text);
					image.setOrder(order);
//					image.setUrl(url);
//					image.setShareable(shareable);
//					image.setExpandable(expandable);
					image.setSrc(src);
//					image.setHtml(html);
//					image.setSize(size);
					image.setPageId(pageId);
//					image.setType("image");
					widgets.add(image);
				}
				
				
				
			}
			connection.close();
			stmt.close();
			results.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return widgets;
		
		}
	
	
	public Widget findWidgetById(int widgetId) {
		ResultSet result = null;
		
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = (PreparedStatement) connection.prepareStatement(FIND_WIDGET_BY_WIDGETID);
			pstmt.setInt(1, widgetId);
			result = pstmt.executeQuery();
			
			
			
			if(result.next()) {
			
				String name = result.getString("name");
				int width = result.getInt("width");
				int height = result.getInt("height");
				String cssClass = result.getString("cssClass");
				String cssStyle = result.getString("cssStyle");
				String text = result.getString("text");
				int order = result.getInt("order");
				String url = result.getString("url");
				boolean shareable= result.getBoolean("shareable");
				boolean expandable= result.getBoolean("expandable");
				String src = result.getString("src");
				String html = result.getString("html");
				int size = result.getInt("size");
				int pageId = result.getInt("pageId");
				String type = result.getString("type");
				
				if(type.toString() == "youtube") {
					YouTubeWidget youtube = new YouTubeWidget();
					youtube.setWidgetId(widgetId);
					youtube.setName(name);
					youtube.setWidth(width);
					youtube.setHeight(height);
					youtube.setCssClass(cssClass);
					youtube.setCssStyle(cssStyle);
					youtube.setText(text);
					youtube.setOrder(order);
					youtube.setUrl(url);
					youtube.setShareable(shareable);
					youtube.setExpandable(expandable);
					youtube.setPageId(pageId);
					return youtube;
					
				}
				else if(type.toString() == "heading") {
					HeadingWidget heading = new HeadingWidget();
					heading.setWidgetId(widgetId);
					heading.setName(name);
					heading.setWidth(width);
					heading.setHeight(height);
					heading.setCssClass(cssClass);
					heading.setCssStyle(cssStyle);
					heading.setText(text);
					heading.setOrder(order);
					heading.setSize(size);
					heading.setPageId(pageId);
					heading.setType("heading");
					return heading;
				}
				else if(type.toString() == "html") {
					HtmlWidget Html = new HtmlWidget();
					Html.setWidgetId(widgetId);
					Html.setName(name);
					Html.setWidth(width);
					Html.setHeight(height);
					Html.setCssClass(cssClass);
					Html.setCssStyle(cssStyle);
					Html.setText(text);
					Html.setOrder(order);
					Html.setHtml(html);
					Html.setPageId(pageId);
					return Html;
					
				}
				else {
					ImageWidget image = new ImageWidget();
					image.setWidgetId(widgetId);
					image.setName(name);
					image.setWidth(width);
					image.setHeight(height);
					image.setCssClass(cssClass);
					image.setCssStyle(cssStyle);
					image.setText(text);
					image.setOrder(order);
					image.setSrc(src);
					image.setPageId(pageId);
					return image;
				}
				
			}
			
			connection.close();
		    pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return null;
		
		}
	
	public List<Widget> findWidgetsForPage(int pageId) {
		List<Widget> widgets = new ArrayList<Widget>();
		ResultSet results = null;
		
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = (PreparedStatement) connection.prepareStatement(FIND_WIDGETS_FOR_PAGE);
			pstmt.setInt(1, pageId);
			results = pstmt.executeQuery();
			
			
			
			while(results.next()) {
//				Widget widget = new Widget();
				
				int widgetId = results.getInt("widgetId");
				String name = results.getString("name");
				int width = results.getInt("width");
				int height = results.getInt("height");
				String cssClass = results.getString("cssClass");
				String cssStyle = results.getString("cssStyle");
				String text = results.getString("text");
				int order = results.getInt("order");
				String url = results.getString("url");
				boolean shareable= results.getBoolean("shareable");
				boolean expandable= results.getBoolean("expandable");
				String src = results.getString("src");
				String html = results.getString("html");
				int size = results.getInt("size");
				String type = results.getString("type");
				
			

				if(type.toString() == "youtube") {
					YouTubeWidget youtube = new YouTubeWidget();
					youtube.setWidgetId(widgetId);
					youtube.setName(name);
					youtube.setWidth(width);
					youtube.setHeight(height);
					youtube.setCssClass(cssClass);
					youtube.setCssStyle(cssStyle);
					youtube.setText(text);
					youtube.setOrder(order);
					youtube.setUrl(url);
					youtube.setShareable(shareable);
					youtube.setExpandable(expandable);
//					youtube.setSrc(src);
//					youtube.setHtml(html);
//					youtube.setSize(size);
					youtube.setPageId(pageId);
//					youtube.setType("youtube");
					widgets.add(youtube);
					
				}
				else if(type.toString() == "heading") {
					HeadingWidget heading = new HeadingWidget();
					heading.setWidgetId(widgetId);
					heading.setName(name);
					heading.setWidth(width);
					heading.setHeight(height);
					heading.setCssClass(cssClass);
					heading.setCssStyle(cssStyle);
					heading.setText(text);
					heading.setOrder(order);
//					heading.setUrl(url);
//					heading.setShareable(shareable);
//					heading.setExpandable(expandable);
//					heading.setSrc(src);
//					heading.setHtml(html);
					heading.setSize(size);
					heading.setPageId(pageId);
					heading.setType("heading");
					widgets.add(heading);
				}
				else if(type.toString() == "html") {
					HtmlWidget Html = new HtmlWidget();
					Html.setWidgetId(widgetId);
					Html.setName(name);
					Html.setWidth(width);
					Html.setHeight(height);
					Html.setCssClass(cssClass);
					Html.setCssStyle(cssStyle);
					Html.setText(text);
					Html.setOrder(order);
//					Html.setUrl(url);
//					Html.setShareable(shareable);
//					Html.setExpandable(expandable);
//					Html.setSrc(src);
					Html.setHtml(html);
//					Html.setSize(size);
					Html.setPageId(pageId);
//					Html.setType("html");
					widgets.add(Html);
					
				}
				else {
					ImageWidget image = new ImageWidget();
					image.setWidgetId(widgetId);
					image.setName(name);
					image.setWidth(width);
					image.setHeight(height);
					image.setCssClass(cssClass);
					image.setCssStyle(cssStyle);
					image.setText(text);
					image.setOrder(order);
//					image.setUrl(url);
//					image.setShareable(shareable);
//					image.setExpandable(expandable);
					image.setSrc(src);
//					image.setHtml(html);
//					image.setSize(size);
					image.setPageId(pageId);
//					image.setType("image");
					widgets.add(image);
				}
				
				
				
			}
			connection.close();
			pstmt.close();
			results.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return widgets;
		
		}
	
	public int updateWidget(int widgetId, Widget widget) {
		
		connection = null;
		pstmt = null;
		
	    try {
	      Class.forName(JDBC_DRIVER);
	      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	      pstmt = connection.prepareStatement(UPDATE_WIDGET);
	      pstmt.setInt(1, widget.getWidgetId());
	      pstmt.setString(2, widget.getName());
	      pstmt.setInt(3, widget.getWidth());
	      pstmt.setInt(4, widget.getHeight());
	      pstmt.setString(5, widget.getCssClass());
	      pstmt.setString(6, widget.getCssStyle());
	      pstmt.setString(7, widget.getText());
	      pstmt.setInt(8, widget.getOrder());
	      pstmt.setString(9, widget.getUrl());
	      pstmt.setBoolean(10, widget.getShareable());
	      pstmt.setBoolean(11, widget.getExpandable());
	      pstmt.setString(12, widget.getSrc());
	      pstmt.setString(13, widget.getHtml());
	      pstmt.setInt(14, widget.getSize());
	      pstmt.setInt(15, widget.getPageId());
	      pstmt.setString(16, widget.getType());
		  int result = pstmt.executeUpdate(); 
		  pstmt.close();
		  connection.close();
		  return result;
		  
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return 1;
		
	}
	
	public int deleteWidget(int widgetId) {
		
		connection = null;
		pstmt = null;
		
	    try {
	      Class.forName(JDBC_DRIVER);
	      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	      pstmt = connection.prepareStatement(DELETE_WIDGET);
		  pstmt.setInt(1, widgetId);
		  return pstmt.executeUpdate(); 
		  
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return -1;
		}
	
	
	
	
}
