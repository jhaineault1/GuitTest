package criticbot;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;


public class CriticBotGUI {
	
	private int textFieldCols = 12;
	private JFrame window;
	
	public CriticBotGUI() 
	{
		  this.window = new JFrame("Critic Bot");
		  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  JPanel content = new JPanel();
		  content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		  JPanel topTenButtonsPanel = this.buildTopTenButtonsPanel();
		  content.add(topTenButtonsPanel);
		  
		  JPanel userInputPanel = this.buildUserInputPanel();
		  content.add(userInputPanel);
		  
		  JPanel resultsPanel = new JPanel();
		  resultsPanel.setPreferredSize(new Dimension(640, 480));
		  JScrollPane scrollable = new JScrollPane(resultsPanel);
		  content.add(scrollable);
		  
	      window.setContentPane(content);
	      window.setLocation(100,100);
	      window.pack();
	      window.setVisible(true);
	}
	
	
	
	private JPanel buildUserInputPanel()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		/**
		 * Query 1: 
		 * Provide a “See the Top Popular Movies” feature. Show a ranking of the top-k
		 * movies with the highest Rotten Tomatoes audience scores without regard to
		 * their genres. Here k is a parameter set by user. Each movie should show its
		 * title, year, its Rotten Tomatoes audience score, its Rotten Tomatoes cover
		 * picture and its IMDb cover picture.
		 */
		JPanel topMoviesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton topMoviesBtn = new JButton("See the Top Popular Movies");
		JLabel topMoviesDataLbl = new JLabel("How many results: ");
		JTextField topMoviesFld = new JTextField("", this.textFieldCols);
		topMoviesBtn.addActionListener(new ActionListener() {
			JFrame window = this.window;
			
			@Override
			public void actionPerformed(ActionEvent event) {
				String fieldTxt = topMoviesFld.getText();
				int limit = 10;
				try {
					limit = Integer.parseInt(fieldTxt);
				} catch(Exception e) {
					//do nothing. use default limit.
				}
				String testString = "Limit is " + limit;
				JOptionPane.showMessageDialog(window,
					    "WARNING.",
					    testString,
					    JOptionPane.WARNING_MESSAGE);
			}
		});
		topMoviesPanel.add(topMoviesBtn);
		topMoviesPanel.add(topMoviesDataLbl);
		topMoviesPanel.add(topMoviesFld);
		
		
		/**
		 * Query 2: 
		 * For any movie title specified by user, show its title, year, its Rotten Tomatoes	
		 * audience score, its Rotten Tomatoes cover picture, its IMDb cover picture and
		 * all the user tags associated to that movie. Provide substring pattern matching.
		 */
		JPanel movieSearchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel movieDataLbl = new JLabel("Search for a movie");
		JTextField movieDataFld = new JTextField("", this.textFieldCols);
		JButton movieDataBtn = new JButton("OK");
		movieDataBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//need to do stuff with moveDataFld
				
			}
		});
		movieSearchPanel.add(movieDataLbl);
		movieSearchPanel.add(movieDataFld);
		movieSearchPanel.add(movieDataBtn);
		
		/**
		 * Query 3:
		 * For any movie genre name specified by user, show the top-k movies in that
		 * particular genre with the highest Rotten Tomatoes audience scores. Here k is a
		 * parameter set by user. Again, each movie should show its title, year, its Rotten
		 * Tomatoes audience score, its Rotten Tomatoes cover picture and its IMDb
		 * cover picture.
		 */
		JPanel genreSearchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel genreDataLbl = new JLabel("Search the top movies in the specified genre: ");
		JTextField genreFld = new JTextField("", this.textFieldCols);
		JLabel genreLimitLbl = new JLabel("How many results: ");
		JTextField genreLimitFld = new JTextField("", this.textFieldCols);
		JButton genreBtn = new JButton("OK");
		genreBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		genreSearchPanel.add(genreDataLbl);
		genreSearchPanel.add(genreFld);
		genreSearchPanel.add(genreLimitLbl);
		genreSearchPanel.add(genreLimitFld);
		genreSearchPanel.add(genreBtn);
		
		/**
		 * Query 4:
		 * For any director name specified by user, show all the movies directed by him
		 * or her. Again, each movie should show its title, year, its Rotten Tomatoes
		 * audience score, its Rotten Tomatoes cover picture and its IMDb cover picture.
		 * Provide substring pattern matching.
		 */
		JPanel directorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel directorLbl = new JLabel("Show all movies directed by the specified director: ");
		JTextField directorFld = new JTextField("", this.textFieldCols);
		JButton directorBtn = new JButton("OK");
		directorBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//needs substring matching!!
				
			}
		});
		directorPanel.add(directorLbl);
		directorPanel.add(directorFld);
		directorPanel.add(directorFld);
		
		/**
		 * Query 5:
		 * For any actor name specified by user, show all the movies which he or she
		 * appears in. Again, each movie should show its title, year, its Rotten Tomatoes
	 	 * audience score, its Rotten Tomatoes cover picture and its IMDb cover picture.
		 * Provide substring pattern matching.
		 */
		JPanel actorsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel actorsLbl = new JLabel("Show all movies for the specified actor: ");
		JTextField actorsFld = new JTextField("", this.textFieldCols);
		JButton actorsBtn = new JButton("OK");
		actorsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//needs substring matching!!
				
			}
		});
		actorsPanel.add(actorsLbl);
		actorsPanel.add(actorsFld);
		actorsPanel.add(actorsBtn);
		
		/**
		 * Query 6: 
		 * For any tag name specified by user, show all the movies associated to that
		 * particular tag, ordered by the average Rotten Tomatoes audience scores.
		 * Again, each movie should show its title, year, its Rotten Tomatoes audience
         * score, its Rotten Tomatoes cover picture and its IMDb cover picture. Provide
		 * substring pattern matching.
		 */
		JPanel movieTagsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel movieTagsLbl = new JLabel("Show all movies for the specified tag: ");
		JTextField movieTagsFld = new JTextField("", this.textFieldCols);
		JButton movieTagsBtn = new JButton("OK");
		movieTagsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stubs
				//needs substring matching!!
				
			}
		});
		movieTagsPanel.add(movieTagsLbl);
		movieTagsPanel.add(movieTagsFld);
		movieTagsPanel.add(movieTagsBtn);
		
		/**
		 * Query 9:
		 * Provide a way to show a timeline of all the watched movies for any given user
		 * (i.e., all the movies she or he has rated on), with the rating she or he gave to
		 * each movie. Show the breakdown by genre, i.e., what percentage of movies in
		 * each genre is out of all the movies she or he watched. 
		 */
		JPanel userStatsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel userStatsLbl = new JLabel("Show stats for the specified user ID: ");
		JTextField userStatsFld = new JTextField("", this.textFieldCols);
		JButton userStatsBtn = new JButton("OK");
		userStatsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//needs substring matching!!
				
			}
		});
		userStatsPanel.add(userStatsLbl);
		userStatsPanel.add(userStatsFld);
		userStatsPanel.add(userStatsBtn);
		
		/**
		 * Query 10: 
		 * Provide a way to show all the tag names associated to a particular movie
		 * specified by user. 
		 */
		JPanel allTagsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel allTagsLbl = new JLabel("Show all tags for the specified movie: ");
		JTextField allTagsFld = new JTextField("", this.textFieldCols);
		JButton allTagsBtn = new JButton("OK");
		allTagsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//needs substring matching!!
				
			}
		});
		allTagsPanel.add(allTagsLbl);
		allTagsPanel.add(allTagsFld);
		allTagsPanel.add(allTagsBtn);
		
		
		//Add each panel to the main panel
		mainPanel.add(topMoviesPanel);
		mainPanel.add(movieSearchPanel);
		mainPanel.add(genreSearchPanel);
		mainPanel.add(directorPanel);
		mainPanel.add(actorsPanel);
		mainPanel.add(movieTagsPanel);
		mainPanel.add(userStatsPanel);
		
		return mainPanel;
	}
	
	private JPanel buildTopTenButtonsPanel()
	{
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		/**
		 * Query 7: 
		 * Provide a “See the Top Popular Directors” feature. Show a ranking of the top-
		 * 10 directors with the highest average Rotten Tomatoes audience scores of all
		 * the movies he or she has directed. To be on the list, one director should direct
		 * at least k movies, where k is a parameter set by user. 
		 */
		JButton topTenDirectorsBtn = new JButton("See the Top Ten Popular Directors");
		topTenDirectorsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		/**
		 * Query 8:
		 * Provide a “See the Top Popular Actors” feature. Show a ranking of the top-10
		 * actors with the highest average Rotten Tomatoes audience scores of all the
		 * movies which he or she has appeared in. To be on the list, one actor should
		 * appear in at least k movies, where k is a parameter set by user.
		 */
		JButton topTenActorsBtn = new JButton("See the Top Ten Popular Actors");
		topTenActorsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		panel.add(topTenDirectorsBtn);
		panel.add(topTenActorsBtn);
		
		return panel;
	}
	
	private ImageIcon fetchWebImage(String url) throws MalformedURLException, IOException {
		BufferedImage img = ImageIO.read(new URL(url));
		return new ImageIcon(img);
	}
}
