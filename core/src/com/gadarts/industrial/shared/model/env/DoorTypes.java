package com.gadarts.industrial.shared.model.env;

import com.gadarts.industrial.shared.assets.Assets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DoorTypes {
	SLIDE(Assets.Sounds.DOOR_OPEN, Assets.Sounds.DOOR_CLOSED), ROTATE(Assets.Sounds.DOOR_OPEN, Assets.Sounds.DOOR_CLOSED);

	private final Assets.Sounds openSound;
	private final Assets.Sounds closedSound;

}
