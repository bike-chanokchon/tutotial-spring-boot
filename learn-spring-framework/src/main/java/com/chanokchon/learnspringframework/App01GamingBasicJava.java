package com.chanokchon.learnspringframework;

import com.chanokchon.learnspringframework.game.GameRunner;
import com.chanokchon.learnspringframework.game.MarioGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		// var game = new SuperContraGame();
		
		var game = new MarioGame();
		var gameRunner = new GameRunner(game);
		
		gameRunner.run();
	}

}
