package com.springboot.rx.videogames;

import io.reactivex.rxjava3.core.Observable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GameService {

    private static final List<Game> GAMES = Arrays.asList(
      new Game("A",10.00,10),
      new Game("B",20.00,20),
      new Game("C",30.00,30),
      new Game("D",40.00,40),
      new Game("E",50.00,50),
      new Game("F",60.00,60)
    );

    public Observable<Game> gamesForSale(){
        return Observable.create(emitter -> {
            int i=0;
            System.out.println("Start sending games");
            while (!emitter.isDisposed() && i<GAMES.size()){
                Game game = GAMES.get(i);
                emitter.onNext(game);
                i++;
            }
            System.out.println("Done sending games");
            emitter.onComplete();
        });
    }
}
