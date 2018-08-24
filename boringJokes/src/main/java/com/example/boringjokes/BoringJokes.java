package com.example.boringjokes;

import java.util.Random;

public class BoringJokes {


    private String[] jokes = new String[]{

            "Q: How many programmers does it take to screw in a light bulb?\n A: None. It's a hardware problem.",
            "Definition, Programmer: An organism that turns caffeine and pizza into software.",
            "A programmer puts two glasses on his bedside table before going to sleep. A full one, in case he gets thirsty, and an empty one, in case he doesn’t.",
            "Software developers like to solve problems. If there are no problems available, they will create their own problems. It’s an addiction.",
            "I’d like to make the world a better place. But they won’t give me the source code…",
            "Java and C were telling jokes. It was C's turn, so he writes something on the wall, points to it and says, \"Do you get the reference?\" But Java didn't."
    };



    public String getJoke(){

        int jokeIndex = new Random().nextInt(jokes.length);
        return jokes[jokeIndex];
    }
}
