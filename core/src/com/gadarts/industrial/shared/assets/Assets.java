package com.gadarts.industrial.shared.assets;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect;
import com.gadarts.industrial.shared.assets.definitions.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Definitions of the game content.
 */
public final class Assets {

	public static final String PATH_SEPARATOR = "/";

	private Assets( ) {
	}

	@Getter
	@RequiredArgsConstructor
	public enum AssetsTypes {
		ATLAS(Atlases.values()),
		MELODY(Melody.values()),
		SOUND(Sounds.values()),
		MODEL(Models.values()),
		SHADER(Shaders.values()),
		TEXTURE(TexturesTypes.getAllDefinitionsInSingleArray()),
		PARTICLES(ParticleEffects.values(), true),
		FONT(Fonts.values());

		private final AssetDefinition[] assetDefinitions;
		private final boolean manualLoad;

		AssetsTypes(final AssetDefinition[] assetDefinitions) {
			this(assetDefinitions, false);
		}

	}

	/**
	 * Texture atlases.
	 */
	@Getter
	public enum Atlases implements AtlasDefinition {
		PLAYER_GENERIC,
		PLAYER_MELEE,
		PLAYER_COLT,
		MAINT_BOT,
		GUARD_BOT,
		TERRORIST_GLOCK;

		private final String filePath;

		Atlases( ) {
			this.filePath = AtlasDefinition.FOLDER + PATH_SEPARATOR + name().toLowerCase() + "." + AtlasDefinition.FORMAT;
		}

		@Override
		public AssetLoaderParameters<Texture> getParameters( ) {
			return null;
		}

		@Override
		public Class<TextureAtlas> getTypeClass( ) {
			return TextureAtlas.class;
		}

		@Override
		public String getName( ) {
			return name();
		}
	}

	/**
	 * Ogg files.
	 */
	@Getter
	public enum Melody implements MelodyDefinition {
		TEST;
		private final String filePath;

		Melody( ) {
			this.filePath = MelodyDefinition.FOLDER + PATH_SEPARATOR + name().toLowerCase() + "." + MelodyDefinition.FORMAT;
		}

		@Override
		public AssetLoaderParameters<Music> getParameters( ) {
			return null;
		}

		@Override
		public Class<Music> getTypeClass( ) {
			return Music.class;
		}
	}

	/**
	 * Shader files.
	 */
	@Getter
	public enum Shaders implements ShaderDefinition {
		MODEL_VERTEX,
		MODEL_FRAGMENT,
		DECAL_VERTEX,
		DECAL_FRAGMENT,
		DECAL_OUTLINE_FRAGMENT,
		DEPTHMAP_VERTEX,
		DEPTHMAP_FRAGMENT,
		SHADOW_VERTEX,
		SHADOW_FRAGMENT;

		private final String filePath;

		Shaders( ) {
			this.filePath = FOLDER + PATH_SEPARATOR + name().toLowerCase() + "." + FORMAT;
		}

		@Override
		public AssetLoaderParameters<String> getParameters( ) {
			return null;
		}

		@Override
		public Class<String> getTypeClass( ) {
			return String.class;
		}
	}

	/**
	 * Shader files.
	 */

	@Getter
	public enum ParticleEffects implements ParticleDefinition {
		BLOOD_SPLATTER, SMALL_EXP, ENERGY_BALL_TRAIL, BULLET_RICOCHET, SMOKE, LASER_EXP;

		private final String filePath;

		ParticleEffects( ) {
			this.filePath = FOLDER + PATH_SEPARATOR + name().toLowerCase() + "." + FORMAT;
		}

		@Override
		public AssetLoaderParameters getParameters( ) {
			return null;
		}

		@Override
		public String getSubFolderName( ) {
			return null;
		}

		@Override
		public Class<ParticleEffect> getTypeClass( ) {
			return ParticleEffect.class;
		}

		@Override
		public String getName( ) {
			return name();
		}
	}

	/**
	 * Fonts files.
	 */
	@Getter
	public enum Fonts implements FontDefinition {
		CONSOLA(15),
		CHUBGOTHIC_SMALL("chubgothic", 40, true),
		CHUBGOTHIC_LARGE("chubgothic", 72, true);

		private final String filePath;
		private final FreetypeFontLoader.FreeTypeFontLoaderParameter params;
		private final String filename;

		Fonts(final int size) {
			this(null, size, false);
		}

		Fonts(final String filename, final int size, final boolean outline) {
			params = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
			this.filename = filename != null ? filename : name().toLowerCase();
			String name = filename == null ? name().toLowerCase() : filename;
			filePath = FontDefinition.FOLDER + PATH_SEPARATOR + name + "." + FontDefinition.FORMAT;
			defineParams(size, outline);
		}

		private void defineParams(final int size, final boolean outline) {
			params.fontParameters.size = size;
			params.fontFileName = filePath;
			if (outline) {
				params.fontParameters.borderWidth = 1f;
				params.fontParameters.borderColor = Color.RED;
			}
		}

		@Override
		public String getAssetManagerKey( ) {
			return filename + "_" + params.fontParameters.size + "." + FontDefinition.FORMAT;
		}

		@Override
		public AssetLoaderParameters<BitmapFont> getParameters( ) {
			return params;
		}

		@Override
		public Class<BitmapFont> getTypeClass( ) {
			return BitmapFont.class;
		}
	}

	/**
	 * Wave files.
	 */
	@Getter
	public enum Sounds implements SoundDefinition {
		STEP("step_1", "step_2", "step_3"),
		ENEMY_ROAM("enemy_roam_1", "enemy_roam_2", "enemy_roam_3"),
		ENEMY_AWAKE("enemy_awake_1", "enemy_awake_2", "enemy_awake_3"),
		ENEMY_PAIN("enemy_pain_1", "enemy_pain_2", "enemy_pain_3"),
		ENEMY_DEATH("enemy_death_1", "enemy_death_2", "enemy_death_3"),
		ATTACK_FIST,
		ATTACK_ENERGY_BALL,
		SMALL_EXP,
		SCORPION_ATTACK,
		SCORPION_AWAKE("scorpion_awake_1", "scorpion_awake_2"),
		SCORPION_PAIN,
		SCORPION_DEATH("scorpion_death_1", "scorpion_death_2"),
		SCORPION_ROAM,
		LIGHT_STEP("light_step_1", "light_step_2", "light_step_3"),
		ATTACK_COLT,
		ATTACK_KNIFE,
		PICKUP,
		PLAYER_PAIN,
		PLAYER_DEATH,
		UI_CLICK(false),
		UI_ITEM_SELECT(false),
		UI_ITEM_PLACED(false),
		AMB_WIND(false, true),
		AMB_CHAINS(true, false, "amb_chains_1", "amb_chains_2", "amb_chains_3"),
		AMB_LAUGH(true, false, "amb_laugh_1"),
		AMB_SIGH(true, false, "amb_sigh_1", "amb_sigh_2");

		private final String filePath;
		private final boolean randomPitch;
		private final boolean loop;
		private final String[] files;

		Sounds( ) {
			this(true);
		}

		Sounds(final boolean randomPitch) {
			this(randomPitch, false);
		}

		Sounds(final boolean randomPitch, final boolean loop) {
			this(randomPitch, loop, new String[0]);
		}

		Sounds(final boolean randomPitch, final boolean loop, final String... files) {
			this.filePath = FOLDER + PATH_SEPARATOR + name().toLowerCase() + "." + FORMAT;
			this.randomPitch = randomPitch;
			this.loop = loop;
			this.files = files;
			IntStream.range(0, files.length).forEach(i -> files[i] = FOLDER + PATH_SEPARATOR + files[i] + "." + FORMAT);
		}

		Sounds(final String... files) {
			this(true, false, files);
		}

		@Override
		public String[] getFilesList( ) {
			return files;
		}

		@Override
		public AssetLoaderParameters<Sound> getParameters( ) {
			return null;
		}

		@Override
		public Class<Sound> getTypeClass( ) {
			return Sound.class;
		}
	}

	/**
	 * 3D models.
	 */
	@Getter
	public enum Models implements ModelDefinition {
		GLOCK,
		WALL_SUPPORTER_1("wall_supporter", "wall_supporter_1_texture"),
		WALL_SUPPORTER_2("wall_supporter", "wall_supporter_2_texture"),
		WALL_SUPPORTER_3("wall_supporter", "wall_supporter_3_texture"),
		WALL_SUPPORTER_HIGH(),
		COMPUTER_WAGON(),
		CRATE_BIG_0("crate_big", "crate_big_texture_0"),
		CRATE_BIG_1("crate_big", "crate_big_texture_1"),
		CRATE_BIG_2("crate_big", "crate_big_texture_2"),
		OFFICE_DESK,
		OFFICE_DESK_DRAWERS,
		OFFICE_DESK_LIGHT,
		RUINS_0,
		RUINS_1,
		MONITOR,
		KEYBOARD,
		PC,
		CRATE_SMALL,
		AUTO_DOOR_0,
		INDUSTRIAL_DOOR_0("industrial_door", "industrial_door_0"),
		INDUSTRIAL_DOOR_1("industrial_door", "industrial_door_1"),
		INDUSTRIAL_DOOR_2("industrial_door", "industrial_door_2"),
		SINK_0("sink", "sink_0"),
		SINK_1("sink", "sink_1"),
		TRASH_CAN,
		DOOR_FRAME_WARNING,
		INDUSTRIAL_DOOR_FRAME,
		CURSOR(0.1F),
		LASER_BULLET,
		GUN_BULLET,
		GUN_BULLET_JACKET,
		METAL_PART,
		EXIT_SIGN,
		EDGE_SAFETY_0("edge_safety", "edge_safety_texture_0"),
		EDGE_SAFETY_1("edge_safety", "edge_safety_texture_1"),
		EDGE_SAFETY_BROKEN,
		ELECTRIC_BOX_0("electric_box", "electric_box_0"),
		ELECTRIC_BOX_1("electric_box", "electric_box_1"),
		SMALL_ELECTRIC_BOX_0("small_electric_box", "small_closet_0"),
		SMALL_ELECTRIC_BOX_1("small_electric_box", "small_closet_1"),
		ELECTRIC_CLOSET_0("electric_closet", "big_electric_box_0"),
		ELECTRIC_CLOSET_1("electric_closet", "big_electric_box_1"),
		OFFICE_CHAIR_0("office_chair", "office_chair_0"),
		OFFICE_CHAIR_1("office_chair", "office_chair_1");
		private final String filePath;
		private final float alpha;
		private final String textureFileName;

		Models( ) {
			this(1.0f, null, null);
		}

		Models(final float alpha, String fileName, String textureFileName) {
			String name = fileName != null ? fileName : name().toLowerCase();
			this.filePath = FOLDER + PATH_SEPARATOR + name + "." + FORMAT;
			this.textureFileName = textureFileName;
			this.alpha = alpha;
		}

		Models(float alpha) {
			this(alpha, null, null);
		}

		Models(String fileName, String textureFileName) {
			this(1.0F, fileName, textureFileName);
		}

		Models(String fileName) {
			this(fileName, null);
		}

		@Override
		public AssetLoaderParameters<Model> getParameters( ) {
			return null;
		}

		@Override
		public Class<Model> getTypeClass( ) {
			return Model.class;
		}
	}

	@Getter
	public enum TexturesTypes {
		Floors(SurfaceTextures.values()),
		Environment(SurfaceTextures.values()),
		UI(UiTextures.values());

		private final TextureDefinition[] definitions;

		TexturesTypes(final TextureDefinition[] definitions) {
			this.definitions = definitions;
		}

		public static TextureDefinition[] getAllDefinitionsInSingleArray( ) {
			ArrayList<TextureDefinition> list = new ArrayList<>();
			Arrays.stream(values()).forEach(defs -> list.addAll(Arrays
					.stream(defs.getDefinitions()).toList())
			);
			return list.toArray(new TextureDefinition[0]);
		}
	}

	/**
	 * Image files of surfaces.
	 */
	@Getter
	public enum SurfaceTextures implements TextureDefinition {
		MISSING,
		INDUSTRIAL_FLOOR_0,
		INDUSTRIAL_FLOOR_1,
		INDUSTRIAL_FLOOR_2,
		INDUSTRIAL_FLOOR_3,
		INDUSTRIAL_FLOOR_4,
		INDUSTRIAL_FLOOR_5,
		INDUSTRIAL_FLOOR_6,
		METALLIC_FLOOR_0,
		METALLIC_FLOOR_1,
		METALLIC_FLOOR_2,
		CONCRETE_WALL_SQUARE_0,
		CONCRETE_WALL_DARKNESS,
		CONCRETE_WALL_HIGH,
		CONCRETE_WALL_0,
		CONCRETE_WALL_1,
		CONCRETE_WALL_2,
		CONCRETE_WALL_3,
		CONCRETE_WALL_4,
		CONCRETE_WALL_5,
		CONCRETE_WALL_6,
		CONCRETE_WALL_7,
		CONCRETE_WALL_8,
		CONCRETE_WALL_9,
		INDUSTRIAL_WALL_0,
		INDUSTRIAL_WALL_1,
		INDUSTRIAL_WALL_2,
		INDUSTRIAL_WALL_3,
		INDUSTRIAL_WALL_4,
		INDUSTRIAL_WALL_5,
		INDUSTRIAL_WALL_6,
		INDUSTRIAL_WALL_7,
		INDUSTRIAL_WALL_8,
		INDUSTRIAL_WALL_9,
		INDUSTRIAL_WALL_10,
		INDUSTRIAL_WALL_BOARD,
		BROKEN_WALL_0,
		BOARD_WALL_0,
		BOARD_WALL_1,
		BOARD_WALL_2,
		BOARD_WALL_3,
		BOARD_WALL_4,
		BOARD_WALL_5,
		MARBLE_WALL_0,
		MARBLE_WALL_1,
		MARBLE_WALL_2,
		MARBLE_WALL_3,
		MARBLE_WALL_4,
		MARBLE_WALL_5,
		MARBLE_WALL_6,
		MARBLE_WALL_7,
		MARBLE_FLOOR_0,
		BLANK,
		;

		private final Texture.TextureWrap textureWrap;

		SurfaceTextures(final Texture.TextureWrap textureWrap) {
			this.textureWrap = textureWrap;
		}

		SurfaceTextures( ) {
			this(Texture.TextureWrap.Repeat);
		}

		@Override
		public String getSubFolderName( ) {
			return "surfaces";
		}

		@Override
		public String getName( ) {
			return name();
		}

		@Override
		public AssetLoaderParameters<Texture> getParameters( ) {
			return null;
		}
	}

	/**
	 * Image files of UI components.
	 */
	@Getter
	public enum UiTextures implements TextureDefinition {
		PATH_ARROW,
		BULB,
		TRIGGER,
		BUTTON_STORAGE(null, "buttons"),
		BUTTON_STORAGE_DOWN(null, "buttons"),
		BUTTON_STORAGE_HOVER(null, "buttons"),
		BUTTON_CLOSE(null, "buttons"),
		BUTTON_CLOSE_DOWN(null, "buttons"),
		BUTTON_CLOSE_HOVER(null, "buttons"),
		NINEPATCHES("ninepatches.9"),
		WEAPON_HAMMER(null, "weapons"),
		WEAPON_COLT(null, "weapons"),
		PLAYER_LAYOUT,
		LOGO(null);

		public static final String SUB_FOLDER_NAME = "ui";
		private final String specialFileName;
		private final String subSubFolder;

		UiTextures( ) {
			this(null);
		}

		UiTextures(final String specialFileName) {
			this(specialFileName, null);
		}

		UiTextures(final String specialFileName, final String subSubFolder) {
			this.specialFileName = specialFileName;
			this.subSubFolder = subSubFolder;
		}

		@Override
		public String getSubFolderName( ) {
			return subSubFolder != null ? SUB_FOLDER_NAME + PATH_SEPARATOR + subSubFolder : SUB_FOLDER_NAME;
		}

		@Override
		public String getName( ) {
			return specialFileName != null ? specialFileName : name();
		}

		@Override
		public AssetLoaderParameters<Texture> getParameters( ) {
			return null;
		}
	}

}
