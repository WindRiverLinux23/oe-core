SUMMARY = "Audio format Conversion library"
DESCRIPTION = "Library for reading and writing files containing sampled \
sound (such as MS Windows WAV and the Apple/SGI AIFF format) through \
one standard library interface."
HOMEPAGE = "https://libsndfile.github.io/libsndfile/"
AUTHOR = "Erik de Castro Lopo"
DEPENDS = "flac libogg libvorbis"
SECTION = "libs/multimedia"
LICENSE = "LGPL-2.1-only"

SRC_URI = "${GITHUB_BASE_URI}/download/${PV}/libsndfile-${PV}.tar.xz \
           file://noopus.patch \
           file://0001-mat4-mat5-fix-int-overflow-in-dataend-calculation.patch \
           file://0002-au-avoid-int-overflow-while-calculating-data_end.patch \
           file://0003-avr-fix-int-overflow-in-avr_read_header.patch \
           file://0004-sds-fix-int-overflow-warning-in-sample-calculations.patch \
           file://0005-aiff-fix-int-overflow-when-counting-header-elements.patch \
           file://0006-ircam-fix-int-overflow-in-ircam_read_header.patch \
           file://0007-mat4-mat5-fix-int-overflow-when-calculating-blockwid.patch \
           file://0008-common-fix-int-overflow-in-psf_binheader_readf.patch \
           file://0009-nms_adpcm-fix-int-overflow-in-signal-estimate.patch \
           file://0010-nms_adpcm-fix-int-overflow-in-sf.frames-calc.patch \
           file://0011-pcm-fix-int-overflow-in-pcm_init.patch \
           file://0012-rf64-fix-int-overflow-in-rf64_read_header.patch \
           file://0013-ima_adpcm-fix-int-overflow-in-ima_reader_init.patch \
          "
GITHUB_BASE_URI = "https://github.com/libsndfile/libsndfile/releases/"

SRC_URI[sha256sum] = "3799ca9924d3125038880367bf1468e53a1b7e3686a934f098b7e1d286cdb80e"

LIC_FILES_CHKSUM = "file://COPYING;md5=e77fe93202736b47c07035910f47974a"

CVE_PRODUCT = "libsndfile"

S = "${WORKDIR}/libsndfile-${PV}"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'alsa', d)}"
PACKAGECONFIG[alsa] = "--enable-alsa,--disable-alsa,alsa-lib"
PACKAGECONFIG[regtest] = "--enable-sqlite,--disable-sqlite,sqlite3"

inherit autotools lib_package pkgconfig multilib_header github-releases

do_install:append() {
    oe_multilib_header sndfile.h
}
