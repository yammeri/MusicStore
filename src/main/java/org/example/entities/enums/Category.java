package org.example.entities.enums;

public enum Category {
    UKULELE("Ukulele"),
    GUITARS("Guitars"),
    KEYBOARDS("Keyboards"),
    PERCUSSION("Percussion"),
    MICROPHONES("Microphones"),
    WIND_INSTRUMENTS("Wind instruments"),
    HARMONICAS_MELODIES("Harmonicas, melodies"),
    BOWED_INSTRUMENTS("Bowed instruments"),
    ACCORDIONS_BAYANS_HARMONIES("Accordions, bayans, harmonies"),
    FOLK_ETHNIC("Folk, ethnic"),
    RADIO_SYSTEMS("Radio systems"),
    STUDIO_EQUIPMENT("Studio equipment"),
    SOUND_EQUIPMENT("Soung equipment"),
    LIGHTING_EQUIPMENT("Lighting equipment"),
    HEADPHONES_HEADSETS("Headphones, headsets"),
    SWITCHING("Switching"),
    AUDIO_VIDEO_EQUIPMENT("Audio-video equipment"),
    LITERATURE("Literature");

    private String value;

    private Category(String value) {
        this.value = value;
    }

    public static Category fromString(String value) throws IllegalAccessException {
        if (value != null) {
            for (Category ct : Category.values()) {
                if (value.equalsIgnoreCase(ct.value)) {
                    return ct;
                }
            }
        }
        throw new IllegalAccessException("No such value");
    }

    public String getValue() {
        return value;
    }
}