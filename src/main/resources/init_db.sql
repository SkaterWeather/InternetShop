CREATE TABLE public.items
(
    id bigint NOT NULL,
    name "char"[] NOT NULL,
    price money[] NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.items
    OWNER to postgres;
