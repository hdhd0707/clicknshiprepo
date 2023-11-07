FROM nginx

COPY /nginx/default.conf /etc/nginx/conf.d/

RUN rm -rf /usr/share/nginx/html/*
COPY /dist/clicknship-app /usr/share/nginx/html

RUN mkdir -p /etc/nginx/certs
COPY /ssl/server.crt /etc/nginx/certs
COPY /ssl/server.key /etc/nginx/certs

RUN chown -R nginx:nginx /etc/nginx/conf.d/ && \
	chown -R nginx:nginx /etc/nginx/certs/ && \
	chown -R nginx:nginx /var/cache/nginx/ && \
	chown -R nginx:nginx /var/log/nginx/ && \
	touch /run/nginx.pid &&	chown -R nginx:nginx /run/nginx.pid && \
	chmod -R 777 /etc/nginx/conf.d 

USER nginx

CMD ["nginx", "-g", "daemon off;"]