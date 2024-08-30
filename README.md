# Network generation

#### Assumptions:
- initial streams have the following schema: (ts timestamp, id int,value int)
- a window query takes in input every stream with at least one timestamp
- a qundow query, that always has a group by clause on the "id" column produces in output 
the following schema: (window_start timestamp, window_end timestamp, id int, agg_value int)
- a join query takes as input two streams, each with at least one timestamp column
- a join query outputs a stream with the following schema:
(ts1 timestamp, id1 int, value1 int, ts2 timestamp, id2 int, valu2 int)


To do:
- generare lo schema di output dalle query
- controllare che una query avvenga su uno stream con schema adatto (elenco di schemi adatto per tipo di query?)