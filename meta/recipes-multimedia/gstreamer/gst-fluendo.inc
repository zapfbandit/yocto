DESCRIPTION = "Fluendo closed-format GStreamer plug-in"
SECTION = "multimedia"
PRIORITY = "optional"
HOMEPAGE = "http://www.fluendo.com/resources/source-plugins.php"
DEPENDS = "gstreamer zlib"

inherit autotools pkgconfig

SRC_URI = "http://core.fluendo.com/gstreamer/src/${BPN}/${BPN}-${PV}.tar.bz2"

FILES_${PN} += "${libdir}/gstreamer-0.10/*.so"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.la ${libdir}/gstreamer-0.10/*.a"

EXTRA_OECONF = "--disable-debug --disable-valgrind"

# Hack to get STAGING_LIBDIR into the linker path when building
CC = "${CCACHE} ${HOST_PREFIX}gcc -L${STAGING_LIBDIR}"

