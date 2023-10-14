package pt.deti.ies.ex4rest;

import java.util.ArrayList;
import java.util.Random;

public class MovieList{
    public ArrayList <Movie> moviesList=new ArrayList<>();
    public MovieList(){
        moviesList = new ArrayList<>();
        Movie movie1= new Movie ("Star Wars, 1977", 1001);
        movie1.addQuotes("Help Me, Obi-Wan Kenobi. You're My Only Hope.");
        movie1.addQuotes("These Aren't The Droids You're Looking For.");
        movie1.addQuotes("I Find Your Lack Of Faith Disturbing.");
        moviesList.add(movie1);
        Movie movie2= new Movie ("Little Women, 2019", 1002);
        movie2.addQuotes("Women, they have minds, and they have souls, as well as just hearts. And they've got ambition, and they've got talent, as well as just beauty. I'm so sick of people saying that love is just all a woman is fit for.");
        movie2.addQuotes("The country just went through a war. People want to be entertained, not preached at.");
        movie2.addQuotes("Don’t let the sun go down on your anger. Forgive her and start again tomorrow.");
        moviesList.add(movie2);
        Movie movie3=new Movie("Mean Girls, 2004", 1003);
        movie3.addQuotes("On Wednesdays we wear pink.");
        movie3.addQuotes("It's not my fault you're, like, in love with me or something!");
        movie3.addQuotes("Grool. I meant to say cool but then I started to say great.");
        moviesList.add(movie3);
        Movie movie4=new Movie("E.T. the Extra-Terrestrial, 1982", 1004);
        movie4.addQuotes("E.T. phone home.");
        movie4.addQuotes("You could be happy here, I could take care of you. I wouldn't let anybody hurt you. We could grow up together, E.T.");
        movie4.addQuotes("Because, um, grown-ups can't see him. Only little kids can see him.");
        moviesList.add(movie4);
        Movie movie5=new Movie("Back to the Future, 1985", 1005);
        movie5.addQuotes("Roads? Where we're going we don't need roads.");
        movie5.addQuotes("No wonder your president has to be an actor. He's gotta look good on television.");
        movie5.addQuotes("If you're gonna build a time machine into a car, why not do it with some style?");
        moviesList.add(movie5);
    }

        public Movie randomMovie() {
            Random random = new Random();
            int len = moviesList.size();
            if (len == 0) {
                return null; // A lista está vazia, não há filmes para escolher.
            }
            int indiceAleatorio = random.nextInt(len);
            return moviesList.get(indiceAleatorio);
        }
        
        public ArrayList<Movie> getMovieList() { //list of all shows
            return moviesList;
        }

        public String getRandomQuote(){ //randomquote
            Movie movie=randomMovie();
            if (movie==null){
                return null;
            }


            ArrayList<String> movieQ= movie.getQuotes();
            if (movieQ==null){
                return null;
            }

            Random random = new Random();
            int len = movieQ.size();
            if (len == 0) {
                return null; // A lista está vazia, não há quotes para escolher.
            }
            int indiceAleatorio = random.nextInt(len);
            return movieQ.get(indiceAleatorio);
            
        }

        public ArrayList<String> getQuotesForMovie(String showid_input) { //quotes por Show
            Movie movieFound = null;
            
            for (Movie movie : moviesList) {
                if (movie.getShowid().equals(showid_input)) {
                    movieFound = movie;
                    break;
                }
            }
            
            if (movieFound != null) {
                return movieFound.getQuotes();
            } else {
                throw new RuntimeException("Filme não encontrado: " + showid_input);
            }
        }

        public String getTitleFromMovieId(String id) {
            for(Movie movie : moviesList){
                if (movie.getShowid().equals(id)){
                    return movie.getTitle().toString();
                }
            }
            return "Movie Id Not Found";
        }
        
    }

