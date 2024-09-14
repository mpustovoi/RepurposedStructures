### **(V.7.5.10 Changes) (1.21.1 Minecraft)**

##### Misc:
Fixed an int overflow bug with the `min_distance_from_world_origin` option used in certain structure sets.
 The bug caused the structures to not spawn in certain areas of the world beyond the world center area.
 Fixing this means the structures will spawn more consistently throughout the world.
 The structures affected by this bug were End Ancient City, End Mineshaft, End Outpost, End Pyramid,
 End Ruined Portals, End Shipwreck, End Stronghold, and Nether Stronghold.