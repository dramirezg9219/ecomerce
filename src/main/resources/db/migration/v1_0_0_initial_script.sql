CREATE TABLE IF NOT EXISTS PRICE (
                                     PRICE_ID BIGINT not null AUTO_INCREMENT PRIMARY KEY,
                                     BRAND_ID int NOT NULL,
                                     START_DATE TIMESTAMP NOT NULL,
                                     END_DATE TIMESTAMP NOT NULL,
                                     PRICE_LIST_ID int NOT NULL,
                                     PRODUCT_ID int NOT NULL,
                                     PRIORITY int NOT NULL,
                                     SALE_PRICE DOUBLE PRECISION NOT NULL,
                                     CURR varchar(5),
                                     INSERT_DATE TIMESTAMP,
                                     UPDATE_DATE TIMESTAMP,
                                     USERNAME varchar(50),
                                     PRIMARY KEY (PRICE_ID)
    );