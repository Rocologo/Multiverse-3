package com.mvplugin.mockbukkit;

import com.mvplugin.core.FileLocations;
import org.bukkit.BlockChangeDelegate;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Item;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pluginbase.bukkit.config.BukkitConfiguration;
import pluginbase.bukkit.config.YamlConfiguration;
import pluginbase.config.SerializationRegistrar;
import pluginbase.config.annotation.SerializeWith;
import pluginbase.config.serializers.Serializer;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class MockWorld implements World {

    static {
        SerializationRegistrar.registerClass(MockWorld.class);
        SerializationRegistrar.registerClass(Location.class);
        SerializationRegistrar.registerClass(UUID.class);
    }

    String name;
    @SerializeWith(UUIDSerializer.class)
    UUID uuid;
    WorldType type = WorldType.NORMAL;
    Environment environment;
    long seed = 0L;
    transient long time = 0L;
    boolean pvp = true;
    boolean keepSpawnInMemory = true;
    Difficulty difficulty = Difficulty.EASY;
    @SerializeWith(LocationSerializer.class)
    Location spawn = new Location(this, 0, 0, 0, 0, 0);

    transient File folder;
    transient File datFile;

    private MockWorld() { }

    public MockWorld(WorldCreator creator) {
        this.name = creator.name();
        this.environment = creator.environment();
        this.type = creator.type();
        this.seed = creator.seed();
        this.uuid = UUID.nameUUIDFromBytes(name.getBytes());
        folder = new File(FileLocations.WORLDS_DIRECTORY, name);
        datFile = new File(folder, "level.dat");
        if (!datFile.exists()) {
            save();
        } else {
            try {
                YamlConfiguration config = BukkitConfiguration.loadYamlConfig(datFile);
                MockWorld world = (MockWorld) config.get(name);
                if (world != null) {
                    this.type = world.type;
                    this.seed = world.seed;
                    this.uuid = world.uuid;
                    this.environment = world.environment;
                    this.spawn = world.spawn;
                    this.difficulty = world.difficulty;
                    this.pvp = world.pvp;
                    this.keepSpawnInMemory = world.keepSpawnInMemory;
                } else {
                    save();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void load() {

    }

    @Override
    public Block getBlockAt(int i, int i2, int i3) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Block getBlockAt(Location location) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBlockTypeIdAt(int i, int i2, int i3) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBlockTypeIdAt(Location location) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getHighestBlockYAt(int i, int i2) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getHighestBlockYAt(Location location) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Block getHighestBlockAt(int i, int i2) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Block getHighestBlockAt(Location location) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Chunk getChunkAt(int i, int i2) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Chunk getChunkAt(Location location) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Chunk getChunkAt(Block block) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isChunkLoaded(Chunk chunk) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Chunk[] getLoadedChunks() {
        return new Chunk[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void loadChunk(Chunk chunk) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isChunkLoaded(int i, int i2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isChunkInUse(int i, int i2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void loadChunk(int i, int i2) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean loadChunk(int i, int i2, boolean b) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadChunk(Chunk chunk) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadChunk(int i, int i2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadChunk(int i, int i2, boolean b) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadChunk(int i, int i2, boolean b, boolean b2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadChunkRequest(int i, int i2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadChunkRequest(int i, int i2, boolean b) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean regenerateChunk(int i, int i2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean refreshChunk(int i, int i2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Item dropItem(Location location, ItemStack itemStack) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Item dropItemNaturally(Location location, ItemStack itemStack) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Arrow spawnArrow(Location location, Vector vector, float v, float v2) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean generateTree(Location location, TreeType treeType) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean generateTree(Location location, TreeType treeType, BlockChangeDelegate blockChangeDelegate) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Entity spawnEntity(Location location, EntityType entityType) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public LivingEntity spawnCreature(Location location, EntityType entityType) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public LivingEntity spawnCreature(Location location, CreatureType creatureType) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public LightningStrike strikeLightning(Location location) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public LightningStrike strikeLightningEffect(Location location) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Entity> getEntities() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<LivingEntity> getLivingEntities() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> tClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Entity> getEntitiesByClasses(Class<?>... classes) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Player> getPlayers() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getUID() {
        return uuid;
    }

    @Override
    public Location getSpawnLocation() {
        return spawn;
    }

    @Override
    public boolean setSpawnLocation(int x, int y, int z) {
        spawn = new Location(this, x, y, z);
        return true;
    }

    @Override
    public long getTime() {
        return time;
    }

    @Override
    public void setTime(long l) {
        this.time = l;
    }

    @Override
    public long getFullTime() {
        return time;
    }

    @Override
    public void setFullTime(long l) {
        time = l;
    }

    @Override
    public boolean hasStorm() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setStorm(boolean b) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getWeatherDuration() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setWeatherDuration(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isThundering() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setThundering(boolean b) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getThunderDuration() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setThunderDuration(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean createExplosion(double v, double v2, double v3, float v4) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean createExplosion(double v, double v2, double v3, float v4, boolean b) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean createExplosion(double v, double v2, double v3, float v4, boolean b, boolean b2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean createExplosion(Location location, float v) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean createExplosion(Location location, float v, boolean b) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Environment getEnvironment() {
        return environment;
    }

    @Override
    public long getSeed() {
        return seed;
    }

    @Override
    public boolean getPVP() {
        return pvp;
    }

    @Override
    public void setPVP(boolean b) {
        this.pvp = b;
    }

    @Override
    public ChunkGenerator getGenerator() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void save() {
        try {
            if (!datFile.exists()) {
                folder.mkdirs();
                datFile.createNewFile();
            }
            YamlConfiguration config = new YamlConfiguration();
            config.set(name, this);
            config.save(datFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BlockPopulator> getPopulators() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends Entity> T spawn(Location location, Class<T> tClass) throws IllegalArgumentException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public FallingBlock spawnFallingBlock(Location location, Material material, byte b) throws IllegalArgumentException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public FallingBlock spawnFallingBlock(Location location, int i, byte b) throws IllegalArgumentException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void playEffect(Location location, Effect effect, int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void playEffect(Location location, Effect effect, int i, int i2) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> void playEffect(Location location, Effect effect, T t) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> void playEffect(Location location, Effect effect, T t, int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ChunkSnapshot getEmptyChunkSnapshot(int i, int i2, boolean b, boolean b2) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setSpawnFlags(boolean b, boolean b2) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getAllowAnimals() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getAllowMonsters() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Biome getBiome(int i, int i2) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setBiome(int i, int i2, Biome biome) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public double getTemperature(int i, int i2) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public double getHumidity(int i, int i2) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getMaxHeight() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getSeaLevel() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getKeepSpawnInMemory() {
        return keepSpawnInMemory;
    }

    @Override
    public void setKeepSpawnInMemory(boolean b) {
        keepSpawnInMemory = b;
    }

    @Override
    public boolean isAutoSave() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAutoSave(boolean b) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public Difficulty getDifficulty() {
        return difficulty;
    }

    @Override
    public File getWorldFolder() {
        return folder;
    }

    @Override
    public WorldType getWorldType() {
        return type;
    }

    @Override
    public boolean canGenerateStructures() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getTicksPerAnimalSpawns() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setTicksPerAnimalSpawns(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getTicksPerMonsterSpawns() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setTicksPerMonsterSpawns(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getMonsterSpawnLimit() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setMonsterSpawnLimit(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getAnimalSpawnLimit() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAnimalSpawnLimit(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getWaterAnimalSpawnLimit() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setWaterAnimalSpawnLimit(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getAmbientSpawnLimit() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAmbientSpawnLimit(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void playSound(Location location, Sound sound, float v, float v2) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String[] getGameRules() {
        return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getGameRuleValue(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean setGameRuleValue(String s, String s2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isGameRule(String s) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setMetadata(String s, MetadataValue metadataValue) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<MetadataValue> getMetadata(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasMetadata(String s) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeMetadata(String s, Plugin plugin) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void sendPluginMessage(Plugin plugin, String s, byte[] bytes) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<String> getListeningPluginChannels() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private static class UUIDSerializer implements Serializer<UUID> {
        @Nullable
        @Override
        public Object serialize(@Nullable UUID uuid) {
            return uuid != null ? uuid.toString() : null;
        }

        @Nullable
        @Override
        public UUID deserialize(@Nullable Object o, @NotNull Class uuidClass) throws IllegalArgumentException {
            return o != null ? UUID.fromString(o.toString()) : null;
        }
    }

    private static class LocationSerializer implements Serializer<Location> {
        @Nullable
        @Override
        public Object serialize(@Nullable Location l) {
            if (l == null) {
                return null;
            }
            Map<String, Object> map = new HashMap<String, Object>(3);
            map.put("x", l.getX());
            map.put("y", l.getY());
            map.put("z", l.getZ());
            return map;
        }

        @Nullable
        @Override
        public Location deserialize(@Nullable Object serialized, @NotNull Class wantedType) throws IllegalArgumentException {
            if (serialized == null || !(serialized instanceof Map)) {
                return null;
            }
            Map map = (Map) serialized;
            double x = 0, y = 0, z = 0;
            try {
                x = Double.valueOf(map.get("x").toString());
                y = Double.valueOf(map.get("y").toString());
                z = Double.valueOf(map.get("z").toString());
            } catch (Exception ignore) { }
            return new Location(null, x, y, z);
        }
    }
}
