import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Song song1 = new Song("phir kabhi",2.50);
        //System.out.println(song1);
        Album album1 = new Album("Arijit Singh","Sukoon");
        System.out.println(album1.addSong("phir kabhi",2.50));
        System.out.println();

        System.out.println(album1.addSong("tujhe kitna chahne lage hum",3.35));
        System.out.println();

        System.out.println(album1.addSong("phir kabhi",2.50));
        System.out.println();

        System.out.println(album1.addSong("kesariya",2.45));
        System.out.println();

        System.out.println(album1.addSong("deva deva",3.15));
        System.out.println();

        System.out.println(album1.findSong("phir kabhi"));
        System.out.println();

        System.out.println(album1.findSong("Hare Ram Hare Krishna"));
        System.out.println();

        LinkedList<Song> favourites = new LinkedList<>();
        System.out.println(album1.addAlbumToPlaylist("phir kabhi",favourites));
        System.out.println();

        System.out.println(album1.addAlbumToPlaylist("PHIR KABHI",favourites));
        System.out.println();

        System.out.println(album1.addAlbumToPlaylist(5,favourites));
        System.out.println();

        System.out.println(album1.addAlbumToPlaylist(3,favourites));
        System.out.println();
        album1.addSong("Hare Ram Hare Krishna",4.5);
        System.out.println(album1.addAlbumToPlaylist("Hare Ram Hare Krishna",favourites));
        System.out.println(album1.addAlbumToPlaylist("deva deva",favourites));
        album1.addSong("Mere ghar ram aaye hai",2.15);
        album1.addAlbumToPlaylist(5,favourites);

        System.out.println(favourites);

        play(favourites);
    }

    public static void play(LinkedList songList){
        ListIterator<Song> player = songList.listIterator();
        Scanner sc = new Scanner(System.in);

        if(songList.isEmpty()){
            System.out.println("Your playlist is empty");
            return;
        }

        printmenu();
        System.out.println("Tell me what you want to do: ");
        boolean quit = false;
        boolean temp = false;
        while(!quit){
            int choice = sc.nextInt();


            switch(choice){
                case 1:
                    printmenu();
                    break;
                case 2:
                    if(player.hasNext()){
                        //System.out.println(temp);
                        if(!temp){
                            System.out.println(player.next());
                        }else{
                            //player.next();
                            //System.out.println("Temp is true");
                            if(player.hasNext()) System.out.println(player.next());
                            else System.out.println("No more songs");
                          // player.previous();
                        }
                        temp = false;
                        }else System.out.println("No more songs");
                    break;
                case 3:

                    if(player.hasPrevious()){
                        //System.out.println(temp);
                        player.previous();
                        if(player.hasPrevious())System.out.println(player.previous());
                        else System.out.println("It is the first song dude");
                        player.next();
                    }else
                        System.out.println("It is the first song dude");

                    temp = true;
                    break;
                case 4:
                    if(temp){
                        player.next();
                        System.out.println(player.previous());
                    }else{
                        player.previous();
                        System.out.println(player.next());
                        //temp = true;
                    }
//                    player.next();
                    break;
                case 5:
                    songList.remove(player.previous());
                    break;
                case 6:
                    System.out.println(songList);
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }
        }

    }

    private static void printmenu() {
        System.out.println("1.Print the menu again");
        System.out.println("2.Play next song");
        System.out.println("3.Play the previous song");
        System.out.println("4.Play the current song again");
        System.out.println("5.Delete current song from the playlist");
        System.out.println("6.Print all the songs");
        System.out.println("7.Quit Application");

    }
}