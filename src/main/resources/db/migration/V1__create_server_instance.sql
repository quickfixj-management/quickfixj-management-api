CREATE TABLE server_instance (
    server_instance_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cluster_url VARCHAR(255)
);
ALTER SEQUENCE server_instance_server_instance_id_seq RESTART 1000;
