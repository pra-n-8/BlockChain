CREATE TABLE blocks (
block_hash TEXT PRIMARY KEY,
block_height INTEGER,
block_time TIMESTAMPTZ
);
CREATE TABLE transactions (
tx_hash TEXT PRIMARY KEY,
tx_block_hash TEXT REFERENCES blocks(block_hash)
);
CREATE TABLE coins (
coin_address TEXT,
coin_amount BIGINT,
coin_creator_tx_hash TEXT REFERENCES transactions(tx_hash),
coin_spender_tx_hash TEXT REFERENCES transactions(tx_hash)
);

INSERT INTO blocks (block_hash, block_height, block_time) VALUES 
('block1', 1, '2022-04-01 12:00:00'),
('block2', 2, '2022-04-01 12:01:00'),
('block3', 3, '2022-04-01 12:02:00'),
('block4', 4, '2022-04-01 12:03:00');

INSERT INTO transactions (tx_hash, tx_block_hash) VALUES 
('tx1', 'block1'),
('tx2', 'block1'),
('tx3', 'block2'),
('tx4', 'block2'),
('tx5', 'block3'),
('tx6', 'block4'),
('tx7', 'block4'),
('tx8', 'block4');

INSERT INTO coins (coin_address, coin_amount, coin_creator_tx_hash, coin_spender_tx_hash) VALUES
('addr1', 100, 'tx1', 'tx2'),
('addr2', 200, 'tx3', NULL),
('addr3', 300, 'tx4', NULL),
('addr4', 400, 'tx5', NULL),
('addr5', 500, 'tx6', 'tx7'),
('addr6', 600, 'tx8', NULL);

select c.coin_address 
from coins c 
group by c.coin_address 
having mod(sum(c.coin_amount),2)=0
order by sum(c.coin_amount) desc 
limit 1;

select b.block_hash as blocks, sum(c.coin_amount) as spent_volume
from blocks b
join transactions t on t.tx_block_hash = b.block_hash
join coins c on c.coin_spender_tx_hash = t.tx_hash
group by b.block_hash
order by spent_volume desc
limit 10;