package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Enemies.Firewisp;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.*;
import NPCs.Walrus;
import Tilesets.EarthTileset;
import Utils.Direction;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class EarthMap extends Map {

    public EarthMap() {
        super("EarthMap.txt", new EarthTileset());
        this.playerStartPosition = getMapTile(4, 18).getLocation();
    }

    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        BugEnemy bugEnemy1 = new BugEnemy(getMapTile(19, 26).getLocation().subtractY(25), Direction.LEFT);
        enemies.add(bugEnemy1);

        BugEnemy bugEnemy2 = new BugEnemy(getMapTile(28, 27).getLocation().subtractY(25), Direction.LEFT);
        enemies.add(bugEnemy2);

        BugEnemy bugEnemy3 = new BugEnemy(getMapTile(16, 17).getLocation().subtractY(25), Direction.LEFT);
        enemies.add(bugEnemy3);

        BugEnemy bugEnemy4 = new BugEnemy(getMapTile(16, 17).getLocation().subtractY(25), Direction.RIGHT);
        enemies.add(bugEnemy4);

        DinosaurEnemy dinosaurEnemy1 = new DinosaurEnemy(getMapTile(10, 25).getLocation().addY(2), getMapTile(13, 25).getLocation().addY(2), Direction.LEFT);
        enemies.add(dinosaurEnemy1);

        DinosaurEnemy dinosaurEnemy2 = new DinosaurEnemy(getMapTile(31, 26).getLocation().addY(2), getMapTile(36, 26).getLocation().addY(2), Direction.LEFT);
        enemies.add(dinosaurEnemy2);

        DinosaurEnemy dinosaurEnemy3 = new DinosaurEnemy(getMapTile(32, 17).getLocation().addY(2), getMapTile(40, 13).getLocation().addY(2), Direction.LEFT);
        enemies.add(dinosaurEnemy3);

        DinosaurEnemy dinosaurEnemy4 = new DinosaurEnemy(getMapTile(48, 13).getLocation().addY(2), getMapTile(55, 13).getLocation().addY(2), Direction.LEFT);
        enemies.add(dinosaurEnemy4);

        // temporary for troubleshooting
        Firewisp firewisp1 = new Firewisp(getMapTile(11, 24).getLocation().addY(2), getMapTile(17,24).getLocation().addY(2), Direction.LEFT);
        enemies.add(firewisp1);

        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        HorizontalMovingPlatform hmp = new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getMapTile(24, 6).getLocation(),
                getMapTile(27, 6).getLocation(),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        );
        enhancedMapTiles.add(hmp);

        HorizontalMovingPlatform hmp2 = new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getMapTile(47, 6).getLocation(),
                getMapTile(50, 6).getLocation(),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        );
        enhancedMapTiles.add(hmp2);

        HorizontalMovingPlatform hmp3 = new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getMapTile(49, 10).getLocation(),
                getMapTile(53, 10).getLocation(),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        );
        enhancedMapTiles.add(hmp3);

        EndLevelBox endLevelBox = new EndLevelBox(getMapTile(64, 9).getLocation());
        enhancedMapTiles.add(endLevelBox);

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Walrus walrus = new Walrus(getMapTile(48, 26).getLocation().subtractY(13));
        npcs.add(walrus);

        return npcs;
    }
}
