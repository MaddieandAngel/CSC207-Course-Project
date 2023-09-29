# CSC207 Course Project

## Domain and Application Information

### Problem Domain

The problem domain of our project is about combat system, card drawing API, text based adventure video game. Our project will be mainly focusing on connecting to an API that shuffles or draws cards, and use that as helper method to create our own combat  game. 
Our combat game is a card-based, turn-based combat game that combines the elements of card games and traditional RPG mechanics with stories. It involves players drawing cards, attacking and defending. The players need to make the best decision to beat the enemy. A level system will also be included, and as players level up, the enemies will become more difficult to defeat. But the complexity of our final product may be reduced due to the limit in time and possible technical difficulties.

### Our Application

The primary focus of our application, which is also the part we will be using an API for,
is our game's combat system.

These mechanics will be turn-based, and will be built around drawing and playing cards from
a single deck. Each suit corresponds to an element (where each suit has one other suit that
it is stronger against), and the particular value of a card determines the base damage it
will deal (1-13, Aces are 1 and Kings are 13).

When in battle, the player has two major actions they can take: Drawing and Attacking. In
order to Attack, the player must play a card from their hand, which will deal damage to the
enemy based on the card's value and suit. Once a card is played, it is sent to a discard
pile, which is shuffled back into the main deck after the battle ends. The player will begin
the game with a couple of cards already in their hand, but once they run out, they will need
to spend a turn Drawing more cards from the deck. We are also thinking of including a Defend
action, which will cause the player to take less damage for a couple of turns after it is
used.

As the player defeats enemies, they will gain experience points and eventually level up.
The amount of health one has is tied to their level, and it is also an additional factor
in calculating damage. Enemies also have levels, which increase as the player progresses
further into the game.

Enemies can perform the same set of actions as the player. However, while the cards the
player Draws are entirely random, enemies will be split into a few unique types who each
have a type of card that they attack with more frequently. For example, a "Lesser Clubs Mage"
would usually use Club suit cards with values ranging from 1 to 7.

Ideally, we would also like the out-of-battle portion of our game to function similarly
to the 1980 video game *Rogue.* However, that is a lower priority task that will only be
attempted once we have completed the combat section, assuming we have enough time to include
it. We *will* still include some sort of non-combat gameplay, of course, but it may be more
akin to a text-based adventure, depending on what we have time for.

## API Usage: The Deck of Cards API

### Documentation Link
https://www.deckofcardsapi.com/
### Using the API
<img width="953" alt="image" src="https://github.com/MaddieandAngel/CSC207-Course-Project/assets/113216817/35a09c84-febc-4aea-95f8-8e21b0917e6f">

### Java Code Output

## Technical Problems

One of the main challenges of this project is creating an attractive user interface for 
our game because no one on our team has much experience in UI design or in creating games. Since there 
is a week in the course dedicated to UI and architecture, so we hope to learn more about 
it in our lectures and tutorials.

We are also wary of how much we can add to our game within the deadline. There are many features we would like to implement.
For example, we would like the player to choose how they traverse the map and have the option to defend themselves in battle. We
will only implement these features if we have enough time.
