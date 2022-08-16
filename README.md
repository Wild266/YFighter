## Welcome to Space Table (Formerly Yeet Fighter)!

### Requirements

Setup Java 7
Setup the Path Environment on your system such that the lines below work:
```
Ensure that importing javax.swing.*; works
Ensure that importing javax.io.*; works
Ensure that importing sun.audio.*; works
Ensure that importing javax.sound.sampled.*; works
```

### Running the game
This is a two-player fighter game. To run the game, please download the repository as a Zip file, unzip it and run Driver.java

If everything works, there may be some green text for errors as the library sun.audio loads the music file, but these should go away soon and the program should not terminate.

When running the file, you should see this Window pop up if the packages are installed correctly:

![image](https://user-images.githubusercontent.com/32823036/184906748-6db9814f-404c-4988-aac1-8b7f5b2cc620.png)


To continue, simply press the Space key on the standard English keyboard.

You should get to a screen that looks like this:

![image](https://user-images.githubusercontent.com/32823036/184906984-1ecc1516-f238-44ed-b52b-6efd70bc47e7.png)


### Playing the game
There are two players on the screen depicted by red and cyan squares. As you may notice the backgrounds change to depict different locations in space. These change at rates proportional to the actual distance between these locations in space. The background will also display the gravitational acceleration at those locations at this value for gravity will be reflected during gameplay (higher gravities will make players fall faster). The white line on the bottom is known as the platform. The two bars on the top of the screen are the health bars for each player. Each player has a set of keys they can use to move left, right, jump (and fall back to the ground), and fall faster to the ground (move downward faster than gravity would naturally take them when not on the ground). Each player also has an attack key they can press to attack the other player and lower the opponent's health bar. When the user of that particular player presses the attack key and a movement key at the same time it changes the attack type. For example, if the cyan player presses their attack key while holding the left arrow key, the a long and slender attack box is displayed protruding out of the left side of the cyan player's avatar. If this attack box touches the red player's avatar, then the red player's health bar will go down just a little bit. Meanwhile, if the cyan player holds the down arrow key while on the platform and then presses the attack button for cyan, a small attack box will protrude from the top of cyan's avatar. If this attack box touches the red player's avatar, then the red player's health bar will go down significantly more than the attack before. However, each player also has a block key which they can use to temporarily makes them invulnerable to their opponent's attacks. If the red player is blocking when the cyan player's attack box touches their avatar, then the red player's health bar remains unchanged. When a player's health bar disappears completely or if that player falls below the platform (by moving off of it), then that player's opponent wins the game!

#### Attacks
There are two main groups of attack types: Air and Basic. Air attacks can be done when the player is in the air but hasn't fallen back down to the platform yet while basic attacks are done when the player is still on the platform. Each attack (and the block) has a cooldown period, which is a short amount of time right after making an attack where you cannot attack temporarily. The cooldown period is indicated as taking place when the respective player's avatar lowers visibly in brightness (The cooldown period for blocking is depicted as taking place when the white square displayed over the avatar is temporarily gray).


##### Basic Attacks
Basic Up - Done by pressing the down movement key while on the platform and then pressing the attack button. Forms an attack box above the avatar.


Basic Directional - Done by pressing the left or right movement keys while on the platform and then pressing the attack button. Forms an attack box to the sides of the avatar.

![image](https://user-images.githubusercontent.com/32823036/184902959-7894c31e-3229-4083-b1d1-54024c639df3.png)


Basic Neutral - Done by pressing no movement keys while on the platform and pressing the attack button. Forms an attack box to the sides of the avatar

![image](https://user-images.githubusercontent.com/32823036/184902699-89de0d19-99d7-42e0-b5ea-471d008d2c5d.png)



##### Air Attacks
Air Down - Done by pressing the down movement key while not on the platform and then pressing the attack button. Forms an attack box above the avatar.

Air Directional - Done by pressing the left or right movement keys while not on the platform and then pressing the attack button. Forms an attack box to the sides of the avatar.

Air Neutral - Done by pressing no movement keys while not on the platform and pressing the attack button. Forms an attack box to the sides of the avatar


#### Cyan Player
The player who wants to use the cyan block can use the arrow keys on the keyboard to move and their attack key is the period button ("."). The Cyan Player's block key is the "/" key. The cyan player's health bar is the one on the top right.

#### Red Player
The player who wants to use the red block can use the WASD keys on the keyboard to move and their attack key is the "F" button without caps lock or shift key pressed (would type "f"). The red player's block key is the "G" button without caps lock or shift pressed (would type "g"). The red player's health bar is the one on the top left.

# Happy space battles!
