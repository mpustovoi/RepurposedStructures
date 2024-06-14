### **(V.7.5.0 Changes) (1.21 Minecraft)**

#### Major:
Ported to 1.21

#### Misc:
`pool_additions` is now renamed to `rs_pool_additions` with the `name` field inside change to `target_pool`.
  Files under same namespace and path aren't merged anymore but will override like normal datapacks. 
  Use the `target_name` field to specify the template pool to merge the additional pool entries into.

`rs_pieces_spawn_counts` is fixed so files properly override each other if under same namespace/path.