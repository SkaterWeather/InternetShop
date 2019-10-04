--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: internet-shop-data; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "internet-shop-data" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';


ALTER DATABASE "internet-shop-data" OWNER TO postgres;

\connect -reuse-previous=on "dbname='internet-shop-data'"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: buckets; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.buckets (
                                id integer NOT NULL,
                                property character varying(255) NOT NULL
);


ALTER TABLE public.buckets OWNER TO postgres;


CREATE SEQUENCE public.buckets_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.buckets_id_seq OWNER TO postgres;

ALTER SEQUENCE public.buckets_id_seq OWNED BY public.buckets.id;


--
-- Name: buckets_items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.buckets_items (
                                      id integer NOT NULL,
                                      bucket_id integer NOT NULL,
                                      item_id integer NOT NULL
);


ALTER TABLE public.buckets_items OWNER TO postgres;

CREATE SEQUENCE public.buckets_items_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.buckets_items_id_seq OWNER TO postgres;

ALTER SEQUENCE public.buckets_items_id_seq OWNED BY public.buckets_items.id;


--
-- Name: items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.items (
                              id integer NOT NULL,
                              name character varying(255) NOT NULL,
                              price double precision NOT NULL
);


ALTER TABLE public.items OWNER TO postgres;

CREATE SEQUENCE public.items_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.items_id_seq OWNER TO postgres;

ALTER SEQUENCE public.items_id_seq OWNED BY public.items.id;


--
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
                               id integer NOT NULL,
                               user_id integer NOT NULL,
                               total_price double precision NOT NULL
);


ALTER TABLE public.orders OWNER TO postgres;

CREATE SEQUENCE public.orders_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_id_seq OWNER TO postgres;

ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.id;


--
-- Name: orders_items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders_items (
                                     id integer NOT NULL,
                                     order_id integer NOT NULL,
                                     item_id integer NOT NULL
);


ALTER TABLE public.orders_items OWNER TO postgres;

CREATE SEQUENCE public.orders_items_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_items_id_seq OWNER TO postgres;

ALTER SEQUENCE public.orders_items_id_seq OWNED BY public.orders_items.id;


--
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
                              id integer NOT NULL,
                              role_name character varying(255) NOT NULL
);


ALTER TABLE public.roles OWNER TO postgres;

CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
                              id integer NOT NULL,
                              login character varying(255) NOT NULL,
                              password character varying(255) NOT NULL,
                              name character varying(255),
                              surname character varying(255),
                              token character varying(255),
                              bucket_id integer NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: users_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_roles (
                                    id integer NOT NULL,
                                    user_id integer NOT NULL,
                                    role_id integer NOT NULL
);


ALTER TABLE public.users_roles OWNER TO postgres;

CREATE SEQUENCE public.users_roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_roles_id_seq OWNER TO postgres;

ALTER SEQUENCE public.users_roles_id_seq OWNED BY public.users_roles.id;


--
-- Name: buckets id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buckets ALTER COLUMN id SET DEFAULT nextval('public.buckets_id_seq'::regclass);


--
-- Name: buckets_items id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buckets_items ALTER COLUMN id SET DEFAULT nextval('public.buckets_items_id_seq'::regclass);


--
-- Name: items id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items ALTER COLUMN id SET DEFAULT nextval('public.items_id_seq'::regclass);


--
-- Name: orders id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders ALTER COLUMN id SET DEFAULT nextval('public.orders_id_seq'::regclass);


--
-- Name: orders_items id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders_items ALTER COLUMN id SET DEFAULT nextval('public.orders_items_id_seq'::regclass);


--
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Name: users_roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles ALTER COLUMN id SET DEFAULT nextval('public.users_roles_id_seq'::regclass);


--
-- Data for Name: buckets; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.buckets (id, property) FROM stdin;
5	DEFAULT
6	DEFAULT
4
7	DEFAULT
\.


--
-- Data for Name: buckets_items; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.buckets_items (id, bucket_id, item_id) FROM stdin;
\.


--
-- Data for Name: items; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.items (id, name, price) FROM stdin;
7	brace	5
8	mace	10
9	Sword	15
\.


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders (id, user_id, total_price) FROM stdin;
\.


--
-- Data for Name: orders_items; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders_items (id, order_id, item_id) FROM stdin;
\.


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, role_name) FROM stdin;
1	USER
2	ADMIN
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, login, password, name, surname, token, bucket_id) FROM stdin;
2	@login	1111	Berry	Garrett	bcecf3f5-06c3-4c23-ae2a-74fdb2649bc8	4
\.


--
-- Data for Name: users_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users_roles (id, user_id, role_id) FROM stdin;
1	2	1
2	2	2
\.



SELECT pg_catalog.setval('public.buckets_id_seq', 7, true);


SELECT pg_catalog.setval('public.buckets_items_id_seq', 26, true);


SELECT pg_catalog.setval('public.items_id_seq', 10, true);


SELECT pg_catalog.setval('public.orders_id_seq', 21, true);


SELECT pg_catalog.setval('public.orders_items_id_seq', 33, true);


SELECT pg_catalog.setval('public.roles_id_seq', 2, true);


SELECT pg_catalog.setval('public.users_id_seq', 3, true);


SELECT pg_catalog.setval('public.users_roles_id_seq', 3, true);


--
-- Name: buckets_items buckets_items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buckets_items
    ADD CONSTRAINT buckets_items_pkey PRIMARY KEY (id);


--
-- Name: buckets buckets_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buckets
    ADD CONSTRAINT buckets_pkey PRIMARY KEY (id);


--
-- Name: items items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT items_pkey PRIMARY KEY (id);


--
-- Name: orders_items orders_items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders_items
    ADD CONSTRAINT orders_items_pkey PRIMARY KEY (id);


--
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: users_roles users_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT users_roles_pkey PRIMARY KEY (id);


--
-- Name: buckets_items buckets_items_buckets_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buckets_items
    ADD CONSTRAINT buckets_items_buckets_fk FOREIGN KEY (bucket_id) REFERENCES public.buckets(id);


--
-- Name: buckets_items buckets_items_items_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buckets_items
    ADD CONSTRAINT buckets_items_items_fk FOREIGN KEY (item_id) REFERENCES public.items(id);


--
-- Name: orders_items orders_items_items_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders_items
    ADD CONSTRAINT orders_items_items_fk FOREIGN KEY (item_id) REFERENCES public.items(id);


--
-- Name: orders_items orders_items_orders_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders_items
    ADD CONSTRAINT orders_items_orders_fk FOREIGN KEY (order_id) REFERENCES public.orders(id);


--
-- Name: orders orders_users_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_users_fk FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: users users_bucket_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_bucket_fk FOREIGN KEY (bucket_id) REFERENCES public.buckets(id);


--
-- Name: users_roles users_roles_role_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT users_roles_role_fk FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- Name: users_roles users_roles_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT users_roles_user_fk FOREIGN KEY (user_id) REFERENCES public.users(id);

--
-- PostgreSQL database dump complete
--
