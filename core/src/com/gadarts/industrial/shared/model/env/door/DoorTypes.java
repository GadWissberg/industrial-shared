package com.gadarts.industrial.shared.model.env.door;

import com.gadarts.industrial.shared.assets.Assets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DoorTypes {
	SLIDE(Assets.Sounds.AUTO_DOOR_OPEN, Assets.Sounds.AUTO_DOOR_CLOSE),
	ROTATE(Assets.Sounds.DOOR_OPEN, Assets.Sounds.DOOR_CLOSED);

	private final Assets.Sounds openSound;
	private final Assets.Sounds closedSound;

}
