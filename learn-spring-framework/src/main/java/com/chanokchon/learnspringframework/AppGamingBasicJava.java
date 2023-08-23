package com.chanokchon.learnspringframework;

import com.chanokchon.learnspringframework.game.SuperContraGame;
import com.chanokchon.learnspringframework.game.GameRunner;
import com.chanokchon.learnspringframework.game.MarioGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		var game = new MarioGame();
		// var game = new SuperContraGame();
		var gameRunner = new GameRunner(game);
		
		gameRunner.run();
	}

}
