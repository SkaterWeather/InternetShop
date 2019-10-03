--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

-- Started on 2019-10-03 23:50:54

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
-- TOC entry 2902 (class 1262 OID 24578)
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
-- TOC entry 205 (class 1259 OID 24719)
-- Name: buckets; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.buckets (
                                id integer NOT NULL,
                                property character varying(255) NOT NULL
);


ALTER TABLE public.buckets OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24717)
-- Name: buckets_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.buckets_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.buckets_id_seq OWNER TO postgres;

--
-- TOC entry 2903 (class 0 OID 0)
-- Dependencies: 204
-- Name: buckets_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.buckets_id_seq OWNED BY public.buckets.id;


--
-- TOC entry 207 (class 1259 OID 24727)
-- Name: buckets_items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.buckets_items (
                                      id integer NOT NULL,
                                      bucket_id integer NOT NULL,
                                      item_id integer NOT NULL
);


ALTER TABLE public.buckets_items OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 24725)
-- Name: buckets_items_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.buckets_items_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.buckets_items_id_seq OWNER TO postgres;

--
-- TOC entry 2904 (class 0 OID 0)
-- Dependencies: 206
-- Name: buckets_items_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.buckets_items_id_seq OWNED BY public.buckets_items.id;


--
-- TOC entry 197 (class 1259 OID 24642)
-- Name: items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.items (
                              id integer NOT NULL,
                              name character varying(255) NOT NULL,
                              price double precision NOT NULL
);


ALTER TABLE public.items OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 24640)
-- Name: items_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.items_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.items_id_seq OWNER TO postgres;

--
-- TOC entry 2905 (class 0 OID 0)
-- Dependencies: 196
-- Name: items_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.items_id_seq OWNED BY public.items.id;


--
-- TOC entry 201 (class 1259 OID 24662)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
                               id integer NOT NULL,
                               user_id integer NOT NULL,
                               total_price double precision NOT NULL
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 24660)
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orders_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_id_seq OWNER TO postgres;

--
-- TOC entry 2906 (class 0 OID 0)
-- Dependencies: 200
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.id;


--
-- TOC entry 203 (class 1259 OID 24675)
-- Name: orders_items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders_items (
                                     id integer NOT NULL,
                                     order_id integer NOT NULL,
                                     item_id integer NOT NULL
);


ALTER TABLE public.orders_items OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24673)
-- Name: orders_items_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orders_items_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_items_id_seq OWNER TO postgres;

--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 202
-- Name: orders_items_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orders_items_id_seq OWNED BY public.orders_items.id;


--
-- TOC entry 209 (class 1259 OID 24750)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
                              id integer NOT NULL,
                              role_name character varying(255) NOT NULL
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 24748)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

--
-- TOC entry 2908 (class 0 OID 0)
-- Dependencies: 208
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- TOC entry 199 (class 1259 OID 24650)
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

--
-- TOC entry 198 (class 1259 OID 24648)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 2909 (class 0 OID 0)
-- Dependencies: 198
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 211 (class 1259 OID 24758)
-- Name: users_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_roles (
                                    id integer NOT NULL,
                                    user_id integer NOT NULL,
                                    role_id integer NOT NULL
);


ALTER TABLE public.users_roles OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 24756)
-- Name: users_roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_roles_id_seq OWNER TO postgres;

--
-- TOC entry 2910 (class 0 OID 0)
-- Dependencies: 210
-- Name: users_roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_roles_id_seq OWNED BY public.users_roles.id;


--
-- TOC entry 2732 (class 2604 OID 24722)
-- Name: buckets id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buckets ALTER COLUMN id SET DEFAULT nextval('public.buckets_id_seq'::regclass);


--
-- TOC entry 2733 (class 2604 OID 24730)
-- Name: buckets_items id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buckets_items ALTER COLUMN id SET DEFAULT nextval('public.buckets_items_id_seq'::regclass);


--
-- TOC entry 2728 (class 2604 OID 24645)
-- Name: items id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items ALTER COLUMN id SET DEFAULT nextval('public.items_id_seq'::regclass);


--
-- TOC entry 2730 (class 2604 OID 24665)
-- Name: orders id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders ALTER COLUMN id SET DEFAULT nextval('public.orders_id_seq'::regclass);


--
-- TOC entry 2731 (class 2604 OID 24678)
-- Name: orders_items id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders_items ALTER COLUMN id SET DEFAULT nextval('public.orders_items_id_seq'::regclass);


--
-- TOC entry 2734 (class 2604 OID 24753)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- TOC entry 2729 (class 2604 OID 24653)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 2735 (class 2604 OID 24761)
-- Name: users_roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles ALTER COLUMN id SET DEFAULT nextval('public.users_roles_id_seq'::regclass);


--
-- TOC entry 2890 (class 0 OID 24719)
-- Dependencies: 205
-- Data for Name: buckets; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.buckets (id, property) FROM stdin;
5	DEFAULT
6	DEFAULT
4
7	DEFAULT
\.


--
-- TOC entry 2892 (class 0 OID 24727)
-- Dependencies: 207
-- Data for Name: buckets_items; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.buckets_items (id, bucket_id, item_id) FROM stdin;
\.


--
-- TOC entry 2882 (class 0 OID 24642)
-- Dependencies: 197
-- Data for Name: items; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.items (id, name, price) FROM stdin;
7	brace	5
8	mace	10
9	Sword	15
\.


--
-- TOC entry 2886 (class 0 OID 24662)
-- Dependencies: 201
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders (id, user_id, total_price) FROM stdin;
\.


--
-- TOC entry 2888 (class 0 OID 24675)
-- Dependencies: 203
-- Data for Name: orders_items; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders_items (id, order_id, item_id) FROM stdin;
\.


--
-- TOC entry 2894 (class 0 OID 24750)
-- Dependencies: 209
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, role_name) FROM stdin;
1	USER
2	ADMIN
\.


--
-- TOC entry 2884 (class 0 OID 24650)
-- Dependencies: 199
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, login, password, name, surname, token, bucket_id) FROM stdin;
2	@login	1111	Berry	Garrett	bcecf3f5-06c3-4c23-ae2a-74fdb2649bc8	4
3	user	2222	Arian	Stark	a1814d6a-e573-4644-95b0-f5f4336e28fe	7
\.


--
-- TOC entry 2896 (class 0 OID 24758)
-- Dependencies: 211
-- Data for Name: users_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users_roles (id, user_id, role_id) FROM stdin;
1	2	1
2	2	2
3	3	1
\.


--
-- TOC entry 2911 (class 0 OID 0)
-- Dependencies: 204
-- Name: buckets_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.buckets_id_seq', 7, true);


--
-- TOC entry 2912 (class 0 OID 0)
-- Dependencies: 206
-- Name: buckets_items_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.buckets_items_id_seq', 26, true);


--
-- TOC entry 2913 (class 0 OID 0)
-- Dependencies: 196
-- Name: items_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.items_id_seq', 10, true);


--
-- TOC entry 2914 (class 0 OID 0)
-- Dependencies: 200
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_id_seq', 21, true);


--
-- TOC entry 2915 (class 0 OID 0)
-- Dependencies: 202
-- Name: orders_items_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_items_id_seq', 33, true);


--
-- TOC entry 2916 (class 0 OID 0)
-- Dependencies: 208
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 2, true);


--
-- TOC entry 2917 (class 0 OID 0)
-- Dependencies: 198
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 3, true);


--
-- TOC entry 2918 (class 0 OID 0)
-- Dependencies: 210
-- Name: users_roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_roles_id_seq', 3, true);


--
-- TOC entry 2747 (class 2606 OID 24732)
-- Name: buckets_items buckets_items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buckets_items
    ADD CONSTRAINT buckets_items_pkey PRIMARY KEY (id);


--
-- TOC entry 2745 (class 2606 OID 24724)
-- Name: buckets buckets_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buckets
    ADD CONSTRAINT buckets_pkey PRIMARY KEY (id);


--
-- TOC entry 2737 (class 2606 OID 24647)
-- Name: items items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT items_pkey PRIMARY KEY (id);


--
-- TOC entry 2743 (class 2606 OID 24680)
-- Name: orders_items orders_items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders_items
    ADD CONSTRAINT orders_items_pkey PRIMARY KEY (id);


--
-- TOC entry 2741 (class 2606 OID 24667)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 2749 (class 2606 OID 24755)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2739 (class 2606 OID 24658)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2751 (class 2606 OID 24763)
-- Name: users_roles users_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT users_roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2756 (class 2606 OID 24733)
-- Name: buckets_items buckets_items_buckets_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buckets_items
    ADD CONSTRAINT buckets_items_buckets_fk FOREIGN KEY (bucket_id) REFERENCES public.buckets(id);


--
-- TOC entry 2757 (class 2606 OID 24738)
-- Name: buckets_items buckets_items_items_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buckets_items
    ADD CONSTRAINT buckets_items_items_fk FOREIGN KEY (item_id) REFERENCES public.items(id);


--
-- TOC entry 2755 (class 2606 OID 24686)
-- Name: orders_items orders_items_items_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders_items
    ADD CONSTRAINT orders_items_items_fk FOREIGN KEY (item_id) REFERENCES public.items(id);


--
-- TOC entry 2754 (class 2606 OID 24681)
-- Name: orders_items orders_items_orders_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders_items
    ADD CONSTRAINT orders_items_orders_fk FOREIGN KEY (order_id) REFERENCES public.orders(id);


--
-- TOC entry 2753 (class 2606 OID 24668)
-- Name: orders orders_users_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_users_fk FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 2752 (class 2606 OID 24743)
-- Name: users users_bucket_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_bucket_fk FOREIGN KEY (bucket_id) REFERENCES public.buckets(id);


--
-- TOC entry 2759 (class 2606 OID 24769)
-- Name: users_roles users_roles_role_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT users_roles_role_fk FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- TOC entry 2758 (class 2606 OID 24764)
-- Name: users_roles users_roles_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT users_roles_user_fk FOREIGN KEY (user_id) REFERENCES public.users(id);


-- Completed on 2019-10-03 23:50:54

--
-- PostgreSQL database dump complete
--
