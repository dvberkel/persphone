from django.conf.urls.defaults import patterns

# Uncomment the next two lines to enable the admin:
# from django.contrib import admin
# admin.autodiscover()

urlpatterns = patterns('view.appengine.game.views',
	# Example:
	# (r'^appengine/', include('appengine.foo.urls')),

	# Uncomment the admin/doc line below and add 'django.contrib.admindocs' 
	# to INSTALLED_APPS to enable admin documentation:
	# (r'^admin/doc/', include('django.contrib.admindocs.urls')),

	# Uncomment the next line to enable the admin:
	# (r'^admin/', include(admin.site.urls)),
	(r'^$','overview'),
	(r'^new/$','new'),
	(r'^(?P<game_uuid>[0-9a-f\-]+)/$','history'),
	(r'^(?P<game_uuid>[0-9a-f\-]+)/(?P<ply>\d+)/$','history'),
)
